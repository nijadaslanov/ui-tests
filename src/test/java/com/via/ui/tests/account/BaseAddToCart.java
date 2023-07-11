package com.via.ui.tests.account;

import com.via.ui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class BaseAddToCart extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    void set_up() {
        loginPage.get()
                .hover()
                .clickSignInButton()
                .typeEmail("2136082634")
                .clickContinue()
                .typePassword("Nicad3202!")
                .clickSignInWelcomeBack();
        accountPage.get().waitForTitle("Amazon.com. Spend less. Smile more.");
        Assert.assertEquals(accountPage.get().getActualTitle(), "Amazon.com. Spend less. Smile more.", "Title of page not match");

    }
}
