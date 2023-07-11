package com.amazon.ui.tests.account;

import com.amazon.ui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

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
        accountPage.get().waitForTitle("Amazon.com. Spend less. Smile more.");
        Assert.assertEquals(accountPage.get().getActualTitle(), "Amazon.com. Spend less. Smile more.", "Page title does not match expected");

    }
}
