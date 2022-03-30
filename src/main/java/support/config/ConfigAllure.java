package support.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:allure.properties"})
public interface ConfigAllure extends Config {

    @Key("allure.server.host")
    String allureHost();

    @Key("allure.server.port")
    String allurePort();

    @Key("allure.server.project")
    String allureProject();

    @Key("allure.server.force_project_creation")
    String allureForceProjectCreation();

    @Key("allure.server.enable")
    Boolean allureEnable();


}
