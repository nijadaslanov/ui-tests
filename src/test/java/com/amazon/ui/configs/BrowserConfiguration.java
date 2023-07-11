package com.amazon.ui.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:browser.properties"})
public interface BrowserConfiguration extends Config {
    @Key("browser.headless")
    Boolean isBrowserHeadless();

    @Key("browser.default.timeout")
    Double browserDefaultTimeout();

    @Key("browser.navigation.timeout")
    Double browserNavigationTimeout();
}
