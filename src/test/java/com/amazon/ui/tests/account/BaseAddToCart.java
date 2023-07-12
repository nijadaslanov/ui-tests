package com.amazon.ui.tests.account;

import com.amazon.ui.base.BaseTest;
import org.testng.annotations.BeforeMethod;

public abstract class BaseAddToCart extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    void set_up() {

        loadSessionStorage(browserContext.get());

    }
}
