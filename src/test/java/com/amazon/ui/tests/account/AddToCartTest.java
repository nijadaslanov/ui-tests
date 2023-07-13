package com.amazon.ui.tests.account;

import com.amazon.ui.listeners.TestListener;
import com.amazon.ui.pages.account.AccountPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.amazon.ui.constants.TestConstants.ADDED_TO_CART_MSG;
import static com.amazon.ui.constants.TestConstants.CART_EMPTY_MSG;

@Listeners(TestListener.class)
@Slf4j
public class AddToCartTest extends BaseAddToCart {
    private static final String MAC = testDataConfiguration.MacBook();

    @Test(groups = {"p1", "account"}, description = "This test validates that a user can add an item to cart and delete it.")
    void can_add_item_to_cart_and_delete() {

        // Searching for the item
        AccountPage page = accountPage.get()
                .fillSearchBar(MAC)
                .pressSearch();

        // Clicking on the first product link
        page.clickFirstProductLink();

        if (page.getPageElement(AccountPage.LOCATOR_SELECTED_PRODUCT).first() != null) {
            page.addToCart();
            // Clicking on No,Thanks Button if visible
            if (page.getPageElement(AccountPage.LOCATOR_NO_THANKS_BUTTON).isVisible()) {
                page.clickNoThanksBtn();
            }
        } else {
            throw new IllegalStateException("NO_ITEM_FOUND");
        }

        // Checking if the item is added to the cart
        Assert.assertEquals(accountPage.get().getConfirmationMessage(), ADDED_TO_CART_MSG, "No Confirm Msg");

        // Navigate to the shopping cart
        accountPage.get().goToCart();

        String subtotal = accountPage.get().getElementText(AccountPage.LOCATOR_SUBTOTAL);
        int subtotalCount = Integer.parseInt(subtotal.replaceAll("\\D", ""));
        if (subtotalCount == 1) {
            // Fetch the title of the item in the shopping cart
            String shoppingCartItemName = accountPage.get().getElementText(AccountPage.LOCATOR_CART_ITEM);
            log.info("Product name added to cart " + shoppingCartItemName);
            Assert.assertTrue(shoppingCartItemName.trim().contains(MAC));

            // Remove the item from the cart
            accountPage.get().removeItemFromCart();

            // Fetch the message displayed when the cart is empty
            String actualMsg = accountPage.get().getElementText(AccountPage.LOCATOR_EMPTY_CART_MSG).trim();

            // Assert that the message displayed matches the expected "Cart Empty" message
            Assert.assertEquals(actualMsg, CART_EMPTY_MSG, "Empty cart message mismatch");
        } else {
            Assert.fail("Subtotal count is not equal to 1. Unexpected subtotal count: " + subtotalCount);
        }
    }
}
