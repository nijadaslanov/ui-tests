package com.amazon.ui.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:environment.properties"})
public interface EnvironmentConfiguration extends Config {
    @Key("uri")
    String stageBaseURI();

    @Key("email")
    String email();

    @Key("password")
    String password();
}
