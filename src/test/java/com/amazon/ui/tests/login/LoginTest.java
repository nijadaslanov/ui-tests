package com.amazon.ui.tests.login;

import com.amazon.ui.listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.amazon.ui.constants.TestConstants.SIGN_IN_TITLE;

@Listeners(TestListener.class)
public class LoginTest extends BaseLogin {

    @Test(groups = {"p1", "login"}, description = "Tests whether user can login with valid credentials")
    void can_login_with_good_credentials() {

        // Hover over the account list on the login page
        loginPage.get().hoverAccountList()
                // Click on the sign in button
                .clickSignInButton()
                // Enter the user email
                .enterEmail(environmentConfiguration.email())
                // Click continue to proceed with the login process
                .clickContinueButton()
                // Enter the user password
                .enterPassword(environmentConfiguration.password())
                // Click on the sign-in button to submit the credentials
                .clickSignInWelcomeBackButton();

        // Wait until the page title is SIGN_IN_TITLE
        accountPage.get().waitForTitle(SIGN_IN_TITLE);

        saveSessionStorage(page.get());

        // Assert that the actual title of the page matches the expected SIGN_IN_TITLE
        Assert.assertEquals(accountPage.get().getActualTitle(), SIGN_IN_TITLE, "Page title does not match expected");

    }
}


