package com.amazon.ui.pages.account;

import com.amazon.ui.base.BaseAuthenticatedPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AccountPage extends BaseAuthenticatedPage {

    // Locators for various elements on the page
    public static final String LOCATOR_SEARCH_BAR = "//input[@id='twotabsearchtextbox']";
    public static final String LOCATOR_FIRST_PRODUCT = ".a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal";
    public static final String LOCATOR_SELECTED_PRODUCT = "//span[@id='productTitle']";
    public static final String LOCATOR_ADD_TO_CART_BUTTON = "//input[@id='add-to-cart-button']";
    public static final String LOCATOR_NO_THANKS_BUTTON = "//span[contains(@class, 'a-button-base abb-intl-decline')]//input[@class='a-button-input']";
    public static final String LOCATOR_RADIO_BUTTON = "//div[@class='a-column a-span12 accordion-caption']/span[@class='a-text-bold']";
    public static final String LOCATOR_CART_BUTTON = "//a[@href='/cart?ref_=sw_gtc' and contains(@class, 'a-button-text')]";
    public static final String LOCATOR_DELETE_BUTTON = "//input[@value='Delete']";
    public static final String LOCATOR_EMPTY_CART_MSG = "//h1[@class='a-spacing-mini a-spacing-top-base' and normalize-space()='Your Amazon Cart is empty.']";
    public static final String LOCATOR_CONFIRMATION_MSG = "#NATC_SMART_WAGON_CONF_MSG_SUCCESS";
    public static final String LOCATOR_CART_ITEM = "//span[@class='a-truncate-cut']";
    public static final String LOCATOR_SEARCH_ICON = "//input[@id='nav-search-submit-button']";
    public static final String LOCATOR_SUBTOTAL = "//span[@id='sc-subtotal-label-buybox']";

    public AccountPage(Page page) {
        initialize(page);
    }

    @Override
    public Locator getPageElement(String elementLocatorString) {
        return page.locator(elementLocatorString);
    }

    /**
     * Retrieves the inner text of the specified element.
     *
     * @param elementLocatorString The locator string for the element.
     * @return The inner text of the element.
     */
    public String getElementText(String elementLocatorString) {
        return getPageElement(elementLocatorString).innerText();
    }

    /**
     * Fills the search bar with the specified item.
     *
     * @param item The item to search for.
     * @return The updated AccountPage instance.
     */
    public AccountPage fillSearchBar(String item) {
        getPageElement(LOCATOR_SEARCH_BAR).fill(item);
        return this;
    }

    /**
     * Presses the search icon to perform the search.
     *
     * @return The updated AccountPage instance.
     */
    public AccountPage pressSearch() {
        getPageElement(LOCATOR_SEARCH_ICON).click();
        return this;
    }

    /**
     * Clicks on the link of the first product in the search results.
     *
     * @return The updated AccountPage instance.
     */
    public AccountPage clickFirstProductLink() {
        getPageElement(LOCATOR_FIRST_PRODUCT).first().click();
        return this;
    }

    public AccountPage selectRadioButton() {
        getPageElement(LOCATOR_RADIO_BUTTON).click();
        return this;
    }

    /**
     * Adds the selected item to the cart.
     *
     * @return The updated AccountPage instance.
     */
    public AccountPage addToCart() {
        Locator lo = page.locator(LOCATOR_ADD_TO_CART_BUTTON);
        lo.scrollIntoViewIfNeeded();
        lo.click();
        return this;
    }

    public void clickNoThanksBtn() {
        Locator dismissButton = getPageElement(LOCATOR_NO_THANKS_BUTTON);
        dismissButton.click();
    }

    /**
     * Retrieves the confirmation message after adding the item to the cart.
     *
     * @return The confirmation message.
     */

    public String getConfirmationMessage() {
        return getPageElement(LOCATOR_CONFIRMATION_MSG).innerText();
    }

    public AccountPage goToCart() {
        getPageElement(LOCATOR_CART_BUTTON).click();
        return new AccountPage(page);
    }

    /**
     * Retrieves the title of the selected product.
     *
     * @return The title of the selected product.
     */
    public String getSelectedProductTitle() {
        return getPageElement(LOCATOR_SELECTED_PRODUCT).innerText();
    }

    /**
     * Removes the item from the cart.
     */
    public void removeItemFromCart() {
        getPageElement(LOCATOR_DELETE_BUTTON).click();
    }
}
