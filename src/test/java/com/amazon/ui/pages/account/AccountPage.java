package com.amazon.ui.pages.account;

import com.amazon.ui.base.BaseAuthenticatedPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AccountPage extends BaseAuthenticatedPage {

    public static final String LOCATOR_SEARCH_BAR = "//input[@id='twotabsearchtextbox']";
    public static final String LOCATOR_FIRST_PRODUCT = ".a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal";
    public static final String LOCATOR_SELECTED_PRODUCT = "//span[@id='productTitle']";
    public static final String LOCATOR_ADD_TO_CART_BUTTON="//input[@id='add-to-cart-button']";
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

    public String getElementText(String elementLocatorString) {
        return getPageElement(elementLocatorString).innerText();
    }

    public AccountPage fillSearchBar(String item) {
        getPageElement(LOCATOR_SEARCH_BAR).fill(item);
        return this;
    }

    public AccountPage pressSearch() {
        getPageElement(LOCATOR_SEARCH_ICON).click();
        return this;
    }

    public AccountPage clickFirstProductLink() {
        getPageElement(LOCATOR_FIRST_PRODUCT).first().click();
        return this;
    }

    public AccountPage selectRadioButton() {
        getPageElement(LOCATOR_RADIO_BUTTON).click();
        return this;
    }

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

    public String getConfirmationMessage() {
        return getPageElement(LOCATOR_CONFIRMATION_MSG).innerText();
    }

    public AccountPage goToCart() {
        getPageElement(LOCATOR_CART_BUTTON).click();
        return new AccountPage(page);
    }

    public String getSelectedProductTitle() {
        return getPageElement(LOCATOR_SELECTED_PRODUCT).innerText();
    }

    public void removeItemFromCart() {
        getPageElement(LOCATOR_DELETE_BUTTON).click();
    }



}
