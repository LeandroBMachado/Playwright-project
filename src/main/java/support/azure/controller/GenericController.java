package support.azure.controller;



import org.aeonbits.owner.ConfigCache;
import support.azure.config.AzureConfig;

public abstract class GenericController {

    protected AzureConfig azureConfig = ConfigCache.getOrCreate(AzureConfig.class);

    public String getBaseUrl(){
        return String.format("https://%s/%s/%s/",azureConfig.hostAzure(), azureConfig.organization(), azureConfig.project());
    }

}
