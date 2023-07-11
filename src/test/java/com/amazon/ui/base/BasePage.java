package com.amazon.ui.base;

import com.amazon.ui.configs.EnvironmentConfiguration;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.amazon.ui.configs.ConfigurationManager;

public abstract class BasePage<T> {
    protected final EnvironmentConfiguration environmentConfiguration = ConfigurationManager.getEnvironmentConfiguration();

    public abstract T navigate();

    public abstract String getCurrentUrl();

    public abstract Locator getPageElement(String elementLocatorString);

    public Page page;
    public String url;

    public void initialize(Page page, String urlPath) {
        this.page = page;
        this.url = environmentConfiguration.stageBaseURI();
    }

    /**
     * Gets an element from the page from the provided locator String.
     * This is available to use in page objects, but preference is that
     * we use 'getPageElement' as the primary way to get elements from a page.
     */
    protected Locator getPageElementWithWait(Page page, String elementLocatorString) {
        return getPageElementWithWait(page, elementLocatorString, 10000.0);
    }

    /**
     * Gets an element from the page from the provided locator String
     * This is available to use in page objects, but preference is that
     * we use 'getPageElement' as the primary way to get elements from a page.
     */
    protected Locator getPageElementWithWait(Page page, String elementLocatorString, Double timeout) {
        Locator locator = page.locator(elementLocatorString);
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE)
                                .setTimeout(timeout));
        return locator;
    }
}
