package com.amazon.ui.base;

public abstract class BaseAuthenticatedPage<T> extends BasePage<T> {

    public String getActualTitle() {
        return this.page.title();
    }

    public synchronized void waitForTitle(String title) {
        page.waitForFunction("document.title === '" + title + "'");
    }

}
