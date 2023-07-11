package com.amazon.ui.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogConstants {

    public static final String SETTING_UP_TEST = "Setting up browser '{}' for test '{}'";
    public static final String INITIALIZING_PLAYWRIGHT_RUNNER = "Initializing PlaywrightRunner with {} browser.";
    public static final String ASSERTIONS_EXECUTED_CORRECTLY_MSG = "Assertions were executed correctly without errors for test '{}' and browser '{}'.";

    /****************
     * ERROR MESSAGES
     ***************/
    public static final String SETUP_ERROR = "An error occurred during test setup: {}";

}
