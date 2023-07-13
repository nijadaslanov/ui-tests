package com.amazon.ui.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:data.properties"})
public interface TestDataConfiguration extends Config {

    @Key("mac")
    String MacBook();

}
