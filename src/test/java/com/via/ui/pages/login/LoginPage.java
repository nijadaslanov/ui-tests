package com.via.ui.pages.login;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.via.ui.pages.Account.AccountPage;
import com.via.ui.pages.base.BaseUnauthenticatedPage;

public class LoginPage extends BaseUnauthenticatedPage<LoginPage> {
    public static final String EMAIL_INPUT = "//input[@id='ap_email']";
    public static final String PASSWORD_INPUT = "//input[@id='ap_password']";

    public static final String Hover = "#nav-link-accountList";
    public static final String SIGN_IN = "//div[@id='nav-flyout-ya-signin']/a/span[@class='nav-action-inner']";
    public static final String CONTINUE = "//input[@id='continue']";
    public static final String SIGN_IN_For_Welcome_Back = "//input[@id='signInSubmit']";
    public static final String ACCOUNT_NAME = "//div[@data-testid='logged-in-account-button-name' and text()='Hi, Nijad A']";


//    public static final String FORGOT_PASSWORD_LINK = "//a[@data-cy='forgot-password']";
//    public static final String EMAIL_REQUIRED_TEXT = "//div[@role='alert' and @data-cy='email-error']";
//    public static final String PASSWORD_REQUIRED_TEXT = "//div[@role='alert' and @data-cy='password-error']";
//    public static final String INVALID_CREDENTIALS_ALERT = "//div[contains(text(), 'The email or password you entered is incorrect')]";

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

    public AccountPage clickSignInWelcomeBack() {
        getPageElement(SIGN_IN_For_Welcome_Back).click();
        return new AccountPage(page);
    }

    public LoginPage hover() {
        getPageElement(Hover).hover();
        return this;
    }

}
