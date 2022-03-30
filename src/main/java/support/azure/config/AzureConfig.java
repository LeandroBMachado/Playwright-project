package support.azure.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:azure.properties"})
public interface AzureConfig extends Config {

    @Key("integration.azure.enable")
    Boolean integrationAzureEnable();

    @Key("host.azure")
    String hostAzure();

    @Key("project")
    String project();

    @Key("organization")
    String organization();

}
