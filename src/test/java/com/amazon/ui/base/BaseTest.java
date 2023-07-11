package com.amazon.ui.base;

import com.amazon.ui.pages.Account.AccountPage;
import com.amazon.ui.pages.login.LoginPage;

public abstract class BaseTest extends BaseUI {
    protected ThreadLocal<LoginPage> loginPage = ThreadLocal.withInitial(() -> new LoginPage(page.get()));
    protected ThreadLocal<AccountPage> accountPage = ThreadLocal.withInitial(() -> new AccountPage(page.get()));

}
