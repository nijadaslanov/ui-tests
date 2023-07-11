package com.via.ui.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:environment.properties"})
public interface EnvironmentConfiguration extends Config {
    @Key("ui.stage.base.uri")
    String stageBaseURI();

    @Key("ui.stage.login.path")
    String stageLoginPath();

    @Key("ui.stage.account.path")
    String stageAccountPath();

}
