package com.amazon.ui.pages.login;

import com.amazon.ui.pages.base.BaseAuthenticatedPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BaseAuthenticatedPage<LoginPage> {

    public static final String EMAIL_INPUT = "//input[@id='ap_email']";
    public static final String PASSWORD_INPUT = "//input[@id='ap_password']";
    public static final String Hover = "#nav-link-accountList";
    public static final String SIGN_IN = "//div[@id='nav-flyout-ya-signin']/a/span[@class='nav-action-inner']";
    public static final String CONTINUE = "//input[@id='continue']";
    public static final String SIGN_IN_For_Welcome_Back = "//input[@id='signInSubmit']";

    public LoginPage(Page page) {
        initialize(page, environmentConfiguration.stageLoginPath());
    }

    @Override
    public LoginPage navigate() {
        page.navigate(url);
        return this;
    }

    @Override
    public String getCurrentUrl() {
        return page.url();
    }

    @Override
    public Locator getPageElement(String elementLocatorString) {
        return getPageElementWithWait(page, elementLocatorString);
    }

    public LoginPage typeEmail(String email) {
        getPageElement(EMAIL_INPUT).clear();
        getPageElement(EMAIL_INPUT).type(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        getPageElement(PASSWORD_INPUT).clear();
        getPageElement(PASSWORD_INPUT).type(password);
        return this;
    }

    public LoginPage clickSignInButton() {
        page.waitForLoadState();
        getPageElement(SIGN_IN).click();
        return this;
    }

    public LoginPage clickContinue() {
        getPageElement(CONTINUE).click();
        return this;
    }

    public LoginPage clickSignInWelcomeBack() {
        getPageElement(SIGN_IN_For_Welcome_Back).click();
        return this;

    }

    public LoginPage hover() {
        getPageElement(Hover).hover();
        return this;
    }
}
