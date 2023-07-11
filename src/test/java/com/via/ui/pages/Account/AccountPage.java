package com.via.ui.pages.Account;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.via.ui.pages.base.BaseAuthenticatedPage;
import com.via.ui.pages.login.LoginPage;

import java.net.PortUnreachableException;

public class AccountPage extends BaseAuthenticatedPage<AccountPage> {

    public static final String SEARCH_BAR="//input[@id='twotabsearchtextbox']";

    public static final String FIRST_PRODUCT=".a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal";

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

    public AccountPage clickOnRadioBtn(){
        getPageElement("//i[@class='a-icon a-accordion-radio a-icon-radio-active']").click();
        return this;
    }



}
