package com.amazon.ui.tests.account;

import com.amazon.ui.listeners.TestListener;
import com.amazon.ui.pages.account.AccountPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.amazon.ui.constants.TestConstants.ADDED_TO_CART_MSG;
import static com.amazon.ui.constants.TestConstants.CART_EMPTY_MSG;

@Listeners(TestListener.class)
public class AddToCartTest extends BaseAddToCart {

    @Test(groups = {"p1", "account"}, description = "This test validates that a user can add an item to cart and delete it.")
    void can_add_item_to_cart_and_delete() {

        // Searching for the item
        String selectedProductTitle = accountPage.get()
                .fillSearchBar("headphone")
                .pressSearch()
                .clickFirstProductLink()
                .getSelectedProductTitle();

        // Adding the item to the cart
        accountPage.get()
                .selectRadioButton()
                .addToCart()
                .dismissAddOns();

        // Checking if the item is added to the cart
        Assert.assertEquals(accountPage.get().getConfirmationMessage(), ADDED_TO_CART_MSG, "No Confirm Msg");

        // Navigate to the shopping cart
        accountPage.get().goToCart();

        // Fetch the title of the item in the shopping cart
        String shoppingCartItemName = accountPage.get().getElementText(AccountPage.LOCATOR_CART_ITEM);

        // Assert that the product title matches the selected product's title
        Assert.assertEquals(shoppingCartItemName, selectedProductTitle, "Product title not matching");

        // Remove the item from the cart
        accountPage.get().removeItemFromCart();

        // Fetch the message displayed when the cart is empty
        String actualMsg = accountPage.get().getElementText(AccountPage.LOCATOR_EMPTY_CART_MSG).trim();

        // Assert that the message displayed matches the expected "Cart Empty" message
        Assert.assertEquals(actualMsg, CART_EMPTY_MSG, "Empty cart message mismatch");

    }

}

