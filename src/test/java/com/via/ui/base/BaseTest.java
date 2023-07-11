package com.via.ui.base;

import com.via.ui.pages.Account.AccountPage;
import com.via.ui.pages.login.LoginPage;

public abstract class BaseTest extends BaseUI {
    protected ThreadLocal<LoginPage> loginPage = ThreadLocal.withInitial(() -> new LoginPage(page.get()));
    protected ThreadLocal<AccountPage> accountPage = ThreadLocal.withInitial(() -> new AccountPage(page.get()));

//    @BeforeMethod(alwaysRun = true)
//    protected void servicesTestSetup(Method method) {
//        // Keyword names in the UI have restrictions, do not refactor this to use 'getTestEntityName' method.
////        keywordName.set(String.format(UI_TEST_KEYWORD_NAME, LocalDateTime.now().atOffset(ZoneOffset.UTC)));
//    }
//
//    protected String getTestEntityName(String prefix, String testName) {
//        LocalDateTime dateTime = LocalDateTime.now();
//        dateTime.atOffset(ZoneOffset.UTC);
//
//        return String.format(prefix, testName, dateTime);
//    }
//
//    protected static String getGenericDescription(String testEntity) {
//        return String.format(GENERIC_DESCRIPTION, testEntity);
//    }
}
