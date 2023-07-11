package com.amazon.ui.tests.login;

import com.amazon.ui.listeners.TestListener;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTests extends BaseLoginTest {

    @Test(groups = {"p1", "login"})
    @Description("Login with valid credentials")
    void can_login_with_good_credentials() {

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


