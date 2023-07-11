package com.amazon.ui.pages.login;

import com.amazon.ui.base.BaseAuthenticatedPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BaseAuthenticatedPage {

    public static final String LOCATOR_EMAIL_INPUT = "//input[@id='ap_email']";
    public static final String LOCATOR_PASSWORD_INPUT = "//input[@id='ap_password']";
    public static final String LOCATOR_ACCOUNT_LIST_HOVER = "#nav-link-accountList";
    public static final String LOCATOR_SIGN_IN_BUTTON = "//div[@id='nav-flyout-ya-signin']/a/span[@class='nav-action-inner']";
    public static final String LOCATOR_CONTINUE_BUTTON = "//input[@id='continue']";
    public static final String LOCATOR_SIGN_IN_WELCOME_BACK_BUTTON = "//input[@id='signInSubmit']";

    public LoginPage(Page page) {
        initialize(page);
    }

    @Override
    public Locator getPageElement(String elementLocatorString) {
        return getPageElementWithWait(page, elementLocatorString);
    }

    public LoginPage enterEmail(String email) {
        getPageElement(LOCATOR_EMAIL_INPUT).clear();
        getPageElement(LOCATOR_EMAIL_INPUT).type(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        getPageElement(LOCATOR_PASSWORD_INPUT).clear();
        getPageElement(LOCATOR_PASSWORD_INPUT).type(password);
        return this;
    }

    public LoginPage clickSignInButton() {
        page.waitForLoadState();
        getPageElement(LOCATOR_SIGN_IN_BUTTON).click();
        return this;
    }

    public LoginPage clickContinueButton() {
        getPageElement(LOCATOR_CONTINUE_BUTTON).click();
        return this;
    }

    public LoginPage clickSignInWelcomeBackButton() {
        getPageElement(LOCATOR_SIGN_IN_WELCOME_BACK_BUTTON).click();
        return this;
    }

    public LoginPage hoverAccountList() {
        getPageElement(LOCATOR_ACCOUNT_LIST_HOVER).hover();
        return this;
    }

}
