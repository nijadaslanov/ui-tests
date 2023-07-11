package com.amazon.ui.tests.account;

import com.amazon.ui.pages.Account.AccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseAddToCart {

    @Test(groups = {"p1", "account"})
    void can_login_with_good_credentials() {

        String firstSelectedItem = accountPage.get()
                .searchItem("headphone")
                .pressEnter()
                .clickFirstProductLink().getText2();
        accountPage.get()
                .clickOnRadioBtn()
                .clickAddToCart()
                .clickOnNoThanks();
        Assert.assertEquals(accountPage.get().getText(), " Added to Cart", "No Confirm Msg");
        AccountPage afterGoToCart = accountPage.get().clickOnGoToCart();
        String shoppingCartItemName = page.get().locator("//span[@class='a-truncate-cut']").innerText();
        Assert.assertEquals(shoppingCartItemName,firstSelectedItem,"Context not matching");
        accountPage.get().clickOnDelete();
        String actualMsg = accountPage.get().getText(AccountPage.EMPTY_CART_MSG).trim();
        Assert.assertEquals(actualMsg,"Your Amazon Cart is empty.","Msg misMatch");

    }
}
