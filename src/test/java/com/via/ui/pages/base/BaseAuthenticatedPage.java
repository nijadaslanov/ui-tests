package com.via.ui.pages.base;

public abstract class BaseAuthenticatedPage<T> extends BasePage<T> {
    public String getActualTitle() {
        return this.page.title();
    }
}
