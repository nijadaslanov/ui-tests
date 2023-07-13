package com.amazon.ui.configs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigurationManager {
    public static EnvironmentConfiguration getEnvironmentConfiguration() {
        return ConfigFactory.create(EnvironmentConfiguration.class);
    }

    public static BrowserConfiguration getBrowserConfiguration() {
        return ConfigFactory.create(BrowserConfiguration.class);
    }

    public static TestDataConfiguration getTestDataConfiguration() {
        return ConfigFactory.create(TestDataConfiguration.class);
    }
}
