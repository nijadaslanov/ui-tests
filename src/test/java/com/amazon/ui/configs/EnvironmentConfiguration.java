package com.amazon.ui.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:environment.properties"})
public interface EnvironmentConfiguration extends Config {
    @Key("uri")
    String stageBaseURI();

    @Key("ui.stage.login.path")
    String stageLoginPath();

    @Key("ui.stage.account.path")
    String stageAccountPath();

    @Key("email")
    String email();

    @Key("password")
    String password();
}
