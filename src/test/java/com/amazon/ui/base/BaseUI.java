package com.amazon.ui.base;

import com.amazon.ui.configs.EnvironmentConfiguration;
import com.amazon.ui.constants.BrowserConstants;
import com.microsoft.playwright.*;
import com.amazon.ui.configs.BrowserConfiguration;
import com.amazon.ui.configs.ConfigurationManager;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.*;

import static com.amazon.ui.constants.LogConstants.*;

@Slf4j
public abstract class BaseUI {
    BrowserConfiguration browserConfiguration = ConfigurationManager.getBrowserConfiguration();
    EnvironmentConfiguration environmentConfiguration = ConfigurationManager.getEnvironmentConfiguration();

    public static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    public static ThreadLocal<Browser> browser = new ThreadLocal<>();
    public static ThreadLocal<String> browserName = new ThreadLocal<>();
    public static ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    public static ThreadLocal<Page> page = new ThreadLocal<>();
    public static ThreadLocal<SoftAssertions> softAssertions = new ThreadLocal<>();

    @BeforeMethod
    public void beforeMethod(Method method, ITestContext context) {
        browserName.set(Optional.ofNullable(context.getCurrentXmlTest().getParameter(BrowserConstants.BROWSER)).orElse(BrowserConstants.CHROMIUM));
        log.info(SETTING_UP_TEST, browserName.get(), method.getName());

        try {
            log.info(INITIALIZING_PLAYWRIGHT_RUNNER, browserName.get());
            playwright.set(Playwright.create());
            browser.set(instantiateBrowser());
            browserContext.set(getBrowserContext());
            page.set(browser.get().newPage());
            softAssertions.set(new SoftAssertions());
            page.get().navigate(environmentConfiguration.stageBaseURI());
                   // .concat(environmentConfiguration.stageLoginPath()));
        } catch (Exception e) {
            log.error(SETUP_ERROR, e.getMessage());
            log.error(e.toString());
        }
    }

    @AfterMethod
    public void afterMethod() {
        page.get().close();
        browserContext.get().close();
        playwright.get().close();
    }

    @AfterClass(alwaysRun = true)
    protected void afterClass() {
        softAssertions.get().assertAll();
        if (softAssertions.get().errorsCollected().isEmpty()) {
            log.info(ASSERTIONS_EXECUTED_CORRECTLY_MSG,
                     this.getClass().getSimpleName(),
                     browser.get().browserType().name());
        }
    }

    /**
     * Instantiates the kind of browser needed and returns the browser object.
     * The browser name is defined in the testng xml file that is being run.
     */
    private Browser instantiateBrowser() {
        return switch (browserName.get().toLowerCase()) {
            case "safari" -> playwright.get().webkit().launch(getLaunchOptions());
            case "firefox" -> playwright.get().firefox().launch(getLaunchOptions());
            default -> playwright.get().chromium().launch(getLaunchOptions());
        };
    }

    /**
     * @return A BrowserContext object with needed options, headers, timeouts, viewport size, etc...
     */
    private BrowserContext getBrowserContext() {
        BrowserContext browserContext = browser.get()
                .newContext(new Browser.NewContextOptions().setPermissions(List.of(BrowserConstants.GEOLOCATION))
                                    .setExtraHTTPHeaders(Map.of(BrowserConstants.REDUCE_MOTION, BrowserConstants.REDUCE))
                        .setViewportSize(1920, 1000));
        browserContext.setDefaultNavigationTimeout(browserConfiguration.browserNavigationTimeout());
        browserContext.setDefaultTimeout(browserConfiguration.browserDefaultTimeout());

        return browserContext;
    }

    /**
     * @return A LaunchOptions object needed for an instantiating browsers.
     */
    private BrowserType.LaunchOptions getLaunchOptions() {
        Boolean isHeadless = browserConfiguration.isBrowserHeadless();
        isHeadless = (isHeadless == null) ? true : isHeadless;

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(isHeadless);
        launchOptions.setArgs(List.of(BrowserConstants.DISABLE_GPU, BrowserConstants.DISABLE_SOFTWARE_RASTERIZER));

        return launchOptions;
    }
}
