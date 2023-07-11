package com.amazon.ui.tests.account;

import com.amazon.ui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import static com.amazon.ui.constants.TestConstants.SIGN_IN_TITLE;

public abstract class BaseAddToCart extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    void set_up() {
        loginPage.get()
                .hoverAccountList()
                .clickSignInButton()
                .enterEmail(environmentConfiguration.email())
                .clickContinueButton()
                .enterPassword(environmentConfiguration.password())
                .clickSignInWelcomeBackButton();
        accountPage.get().waitForTitle(SIGN_IN_TITLE);
        Assert.assertEquals(accountPage.get().getActualTitle(), SIGN_IN_TITLE, "Page title does not match expected");

    }
}
