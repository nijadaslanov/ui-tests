package com.amazon.ui.tests.account;

import com.amazon.ui.constants.TestConstants;
import com.amazon.ui.listeners.TestListener;
import com.amazon.ui.pages.Account.AccountPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.amazon.ui.constants.TestConstants.ADDED_TO_CART_MSG;
import static com.amazon.ui.constants.TestConstants.CART_EMPTY_MSG;

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

        Assert.assertEquals(accountPage.get().getConfirmationMessage(), ADDED_TO_CART_MSG, "No Confirm Msg");

        accountPage.get().goToCart();

        String shoppingCartItemName = accountPage.get().getElementText(AccountPage.LOCATOR_CART_ITEM);
        Assert.assertEquals(shoppingCartItemName, selectedProductTitle, "Product title not matching");

        accountPage.get().removeItemFromCart();

        String actualMsg = accountPage.get().getElementText(AccountPage.LOCATOR_EMPTY_CART_MSG).trim();
        Assert.assertEquals(actualMsg, CART_EMPTY_MSG, "Empty cart message mismatch");

    }

}
