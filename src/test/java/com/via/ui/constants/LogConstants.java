package com.via.ui.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogConstants {
    public static final String SETTING_UP_TEST = "Setting up browser '{}' for test '{}'";
    public static final String INITIALIZING_PLAYWRIGHT_RUNNER = "Initializing PlaywrightRunner with {} browser.";
    public static final String ASSERTIONS_EXECUTED_CORRECTLY_MSG = "Assertions were executed correctly without errors for test '{}' and browser '{}'.";
    public static final String TEARDOWN = "Tearing down browser '{}' for test '{}'";

    /****************
     * ERROR MESSAGES
     ***************/
    public static final String SETUP_ERROR = "An error occurred during test setup: {}";
    public static final String PLAYWRIGHT_RUNNING_INITIALIZATION_ERROR = "An error occurred while initializing PlaywrightRunner: {}";
    public static final String INVALID_BROWSER_NAME_ERROR = "Browser name '$s' is invalid.";
    public static final String BROWSER_INITIALIZATION_ERROR = "An error occurred during browser initialization: {}";
    public static final String PROPERTIES_FILE_LOCATION_ERROR = "Could not find properties file for environment: {}";
    public static final String READING_PROPERTIES_FILE_ERROR = "Error reading properties file for environment: {}";
    public static final String PROPERTY_NOT_FOUND_MESSAGE = "Property '{}' not found";
    public static final String INVALID_PROPERTY_TYPE_ERROR = "Property value for key '{}' is not of type '{}'.";

    /************
     * LOG COLORS
     ***********/
    public static final String ANSI_CHROME = "\033[38;2;255;204;0m";
    public static final String ANSI_SAFARI = "\033[38;2;102;204;255m";
    public static final String ANSI_FIREFOX = "\033[38;2;255;153;51m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String getLogColorForBrowser(String browserName) {
        return switch (browserName.toLowerCase()) {
            case "chrome" -> ANSI_CHROME;
            case "safari" -> ANSI_SAFARI;
            case "firefox" -> ANSI_FIREFOX;
            default -> ANSI_RESET;
        };
    }
}
