package com.amazon.ui.pages.Account;

import com.amazon.ui.pages.base.BaseAuthenticatedPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AccountPage extends BaseAuthenticatedPage<AccountPage> {

    public static final String LOCATOR_SEARCH_BAR = "//input[@id='twotabsearchtextbox']";
    public static final String LOCATOR_FIRST_PRODUCT = ".a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal";
    public static final String LOCATOR_SELECTED_PRODUCT = "//span[@id='productTitle']";
    public static final String LOCATOR_DISMISS_BUTTON = "//span[contains(@class, 'a-button-base abb-intl-decline')]//input[@class='a-button-input']";
    public static final String LOCATOR_RADIO_BUTTON = "//div[@class='a-column a-span12 accordion-caption']/span[@class='a-text-bold']";
    public static final String LOCATOR_CART_BUTTON = "//a[@href='/cart?ref_=sw_gtc' and contains(@class, 'a-button-text')]";
    public static final String LOCATOR_DELETE_BUTTON = "//input[@value='Delete']";
    public static final String LOCATOR_EMPTY_CART_MSG = "//h1[@class='a-spacing-mini a-spacing-top-base' and normalize-space()='Your Amazon Cart is empty.']";
    public static final String LOCATOR_CONFIRMATION_MSG = "#NATC_SMART_WAGON_CONF_MSG_SUCCESS";

    public AccountPage(Page page) {
        initialize(page, environmentConfiguration.stageAccountPath());
    }

    @Override
    public AccountPage navigate() {
        return null;
    }

    @Override
    public String getCurrentUrl() {
        return page.url();
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

    public AccountPage pressEnter() {
        page.keyboard().press("Enter");
        return this;
    }

    public AccountPage clickFirstProductLink() {
        getPageElement(LOCATOR_FIRST_PRODUCT).first().click();
        return this;
    }

    public AccountPage selectProductByIndex(int index) {
        getPageElement(LOCATOR_FIRST_PRODUCT).nth(index).click();
        return this;
    }

    public AccountPage selectRadioButton() {
        getPageElement(LOCATOR_RADIO_BUTTON).click();
        return this;
    }

    public AccountPage addToCart() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart")).click();
        return this;
    }

    public AccountPage dismissAddOns() {
        Locator dismissButton = getPageElement(LOCATOR_DISMISS_BUTTON);
        if (dismissButton.isVisible()) {
            dismissButton.click();
        }
        return this;
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
