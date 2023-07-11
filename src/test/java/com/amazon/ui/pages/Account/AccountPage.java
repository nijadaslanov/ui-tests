package com.amazon.ui.pages.Account;

import com.amazon.ui.pages.base.BaseAuthenticatedPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AccountPage extends BaseAuthenticatedPage<AccountPage> {

    public static final String SEARCH_BAR = "//input[@id='twotabsearchtextbox']";

    public static final String FIRST_PRODUCT = ".a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal";

    public static final String SELECTED_PRODUCT = "//span[@id='productTitle']";

    public static final String NO_THANKS = "//span[contains(@class, 'a-button-base abb-intl-decline')]//input[@class='a-button-input']";

    public static final String RADIO_BTN = "//div[@class='a-column a-span12 accordion-caption']/span[@class='a-text-bold']";

    public static final String GO_TO_CART = "//a[@href='/cart?ref_=sw_gtc' and contains(@class, 'a-button-text')]";

    public static final String DELETE = "//input[@value='Delete']";

    public static final String EMPTY_CART_MSG = "//h1[@class='a-spacing-mini a-spacing-top-base' and normalize-space()='Your Amazon Cart is empty.']";

    public static final String CONFIRM_MSG = "#NATC_SMART_WAGON_CONF_MSG_SUCCESS";

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


    public String getText(String elementLocatorString) {
        return getPageElement(elementLocatorString).innerText();
    }

    public AccountPage searchItem(String item) {
        getPageElement(SEARCH_BAR).fill(item);
        return this;
    }

    public AccountPage pressEnter() {
        page.keyboard().press("Enter");
        return this;
    }

    public AccountPage clickFirstProductLink() {
        getPageElement(FIRST_PRODUCT).first().click();
        return this;
    }

    public AccountPage clickProductLinkByIndex(int index) {
        getPageElement(FIRST_PRODUCT).nth(index).click();
        return this;
    }

    public AccountPage clickOnRadioBtn() {
        getPageElement(RADIO_BTN).click();
        return this;
    }


    public AccountPage clickAddToCart() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart")).click();
        return this;
    }

    public AccountPage clickOnNoThanks() {
        Locator noThanksButton = getPageElement(NO_THANKS);
        if (noThanksButton.isVisible()) {
            noThanksButton.click();
        }
        return this;
    }


    public String getText() {
        return getPageElement(CONFIRM_MSG).innerText();

    }

    public synchronized void waitForTitle(String title) {
        page.waitForFunction("document.title === '" + title + "'");
    }

    public synchronized AccountPage clickOnGoToCart() {
        getPageElement(GO_TO_CART).click();
        return new AccountPage(page);
    }

    public String getText2() {
        return getPageElement(SELECTED_PRODUCT).innerText();

    }

    public void clickOnDelete() {
        getPageElement(DELETE).click();
    }

}
