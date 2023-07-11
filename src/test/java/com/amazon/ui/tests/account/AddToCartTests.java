package com.amazon.ui.tests.account;

import com.amazon.ui.listeners.TestListener;
import com.amazon.ui.pages.Account.AccountPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class AddToCartTests extends BaseAddToCart {

    @Test(groups = {"p1", "account"})
    void can_add_item_to_cart_and_delete() {

        String selectedProductTitle = accountPage.get()
                .fillSearchBar("headphone")
                .pressSearch()
                .clickFirstProductLink()
                .getSelectedProductTitle();

        accountPage.get()
                .selectRadioButton()
                .addToCart()
                .dismissAddOns();

        Assert.assertEquals(accountPage.get().getConfirmationMessage(), " Added to Cart", "No Confirm Msg");

        accountPage.get().goToCart();

        String shoppingCartItemName = page.get().locator("//span[@class='a-truncate-cut']").innerText();
        Assert.assertEquals(shoppingCartItemName, selectedProductTitle, "Product title not matching");

        accountPage.get().removeItemFromCart();

        String actualMsg = accountPage.get().getElementText(AccountPage.LOCATOR_EMPTY_CART_MSG).trim();
        Assert.assertEquals(actualMsg, "Your Amazon Cart is empty.", "Empty cart message mismatch");

    }

}
