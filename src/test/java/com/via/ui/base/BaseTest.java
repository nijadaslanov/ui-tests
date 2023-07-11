package com.via.ui.base;

import com.via.ui.pages.Account.AccountPage;
import com.via.ui.pages.login.LoginPage;

public abstract class BaseTest extends BaseUI {
    protected ThreadLocal<LoginPage> loginPage = ThreadLocal.withInitial(() -> new LoginPage(page.get()));
    protected ThreadLocal<AccountPage> accountPage = ThreadLocal.withInitial(() -> new AccountPage(page.get()));

}
