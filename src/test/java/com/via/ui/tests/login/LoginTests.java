package com.via.ui.tests.login;

import com.via.ui.pages.Account.AccountPage;
import com.via.ui.pages.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseLoginTest {

    @Test(groups = {"p1", "login"})
    void can_login_with_good_credentials() throws InterruptedException {

        Thread.sleep(2000);
        loginPage.get().hover();
        Thread.sleep(2000);
        loginPage.get().clickSignInButton();
        Thread.sleep(2000);
        Assert.assertEquals(accountPage.get().page.title(), "Amazon Sign-In", "Title of page not match");
        System.out.println("loginPage.get().getCurrentUrl() = " + loginPage.get().getCurrentUrl());
        loginPage.get().typeEmail("2136082634");
        loginPage.get().clickContinue();
        loginPage.get().typePassword("Nicad3202!");
        AccountPage accountPage1 = loginPage.get().clickSignInWelcomeBack();
        accountPage1.page.waitForLoadState();
        Thread.sleep(20000);
        Assert.assertEquals(accountPage1.page.title(), "Amazon.com. Spend less. Smile more.", "Title of page not match");
        System.out.println(accountPage1.getCurrentUrl());
        Thread.sleep(8000);
        accountPage.get().searchItem("headphone").pressEnter();
        accountPage.get().page.waitForLoadState();
        accountPage.get().clickFirstProductLink();
        Thread.sleep(5000);
        accountPage.get().clickOnRadioBtn();
        Thread.sleep(5000);


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


