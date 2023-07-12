package com.amazon.ui.base;

import com.amazon.ui.configs.ConfigurationManager;
import com.amazon.ui.configs.EnvironmentConfiguration;
import com.amazon.ui.pages.account.AccountPage;
import com.amazon.ui.pages.login.LoginPage;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest extends BaseUI {
    protected ThreadLocal<LoginPage> loginPage = ThreadLocal.withInitial(() -> new LoginPage(page.get()));
    protected ThreadLocal<AccountPage> accountPage = ThreadLocal.withInitial(() -> new AccountPage(page.get()));
    protected final EnvironmentConfiguration environmentConfiguration = ConfigurationManager.getEnvironmentConfiguration();

    @AfterMethod()
    public void tearDown(){
        loginPage.remove();
        accountPage.remove();
    }
}
