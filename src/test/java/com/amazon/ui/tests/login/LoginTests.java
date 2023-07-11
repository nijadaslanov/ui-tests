package com.amazon.ui.tests.login;

import com.amazon.ui.listeners.TestListener;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.amazon.ui.constants.TestConstants.SIGN_IN_TITLE;

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
        accountPage.get().waitForTitle(SIGN_IN_TITLE);
        Assert.assertEquals(accountPage.get().getActualTitle(), SIGN_IN_TITLE, "Page title does not match expected");

    }

}


