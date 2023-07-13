package com.amazon.ui.base;

import com.amazon.ui.configs.ConfigurationManager;
import com.amazon.ui.configs.EnvironmentConfiguration;
import com.amazon.ui.configs.TestDataConfiguration;
import com.amazon.ui.listeners.TestListener;
import com.amazon.ui.pages.account.AccountPage;
import com.amazon.ui.pages.login.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class BaseTest extends BaseUI {
    protected ThreadLocal<LoginPage> loginPage = ThreadLocal.withInitial(() -> new LoginPage(page.get()));
    protected ThreadLocal<AccountPage> accountPage = ThreadLocal.withInitial(() -> new AccountPage(page.get()));
    protected static final EnvironmentConfiguration environmentConfiguration = ConfigurationManager.getEnvironmentConfiguration();
    protected static final TestDataConfiguration testDataConfiguration = ConfigurationManager.getTestDataConfiguration();

    @AfterMethod()
    public void tearDown(){
        loginPage.remove();
        accountPage.remove();
    }
}
