package com.via.ui.pages.base;

import static com.via.ui.pages.base.BaseAuthenticatedPageLocators.*;

public abstract class BaseAuthenticatedPage<T> extends BasePage<T> {

    public String getPageTitle() {
        return getPageElement(PAGE_TITLE).innerText();
    }

}
