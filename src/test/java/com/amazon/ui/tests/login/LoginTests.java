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
                .enterEmail("2136082634")
                .clickContinueButton()
                .enterPassword("Nicad3202!")
                .clickSignInWelcomeBackButton();
        accountPage.get().waitForTitle("Amazon.com. Spend less. Smile more.");
        Assert.assertEquals(accountPage.get().getActualTitle(), "Amazon.com. Spend less. Smile more.", "Page title does not match expected");

    }


//        String accountNameText = accountPage.get().getText(LoginPage.ACCOUNT_NAME);
//        assertTrue(accountPage.get()
//                .getPageElement(LoginPage.ACCOUNT_NAME)
//                .isVisible(), "The LoginPage -> email required text was not displayed");
//
//        // Add an assertion to check if the text is equal to "Hi, Nijad A"
//        assertEquals(accountNameText, "Hi, Nijad A", "The text of ACCOUNT_NAME button is not as expected");



//    @Test(groups = {"p1", "login", "subscribers"})
//    void cannot_login_with_incorrect_email() {
//        loginPage.get()
//                .typePassword("Kelanskites123!")
//                .clickSubmitButton();
//        assertTrue(loginPage.get()
//                           .getPageElement(loginPage.get().EMAIL_REQUIRED_TEXT)
//                           .isVisible(), "The LoginPage -> email required text was not displayed");
//        loginPage.get()
//                .typeEmail("flying.spaghetti.monster@gmail.com")
//                .clickSubmitButton();
//        assertTrue(loginPage.get()
//                           .getPageElement(loginPage.get().INVALID_CREDENTIALS_ALERT)
//                           .isVisible(), "The LoginPage -> incorrect email/password alert was not displayed");
//    }
//
//    @Test(groups = {"p1", "login", "subscribers"})
//    void cannot_login_with_incorrect_password() {
//        loginPage.get()
//                .typeEmail("kelan.larkin+kelanskites@viacustomers.com")
//                .clickSubmitButton();
//        assertTrue(loginPage.get()
//                           .getPageElement(loginPage.get().PASSWORD_REQUIRED_TEXT)
//                           .isVisible(), "The LoginPage -> password required text was not displayed");
//        loginPage.get()
//                .typePassword("WeAreTheKnightsWhoSayNi!")
//                .clickSubmitButton();
//        assertTrue(loginPage.get()
//                           .getPageElement(loginPage.get().INVALID_CREDENTIALS_ALERT)
//                           .isVisible(), "The LoginPage -> incorrect email/password alert was not displayed");
//    }
}


