package support.config;

import org.aeonbits.owner.ConfigCache;
import support.azure.model.attachment.Attachment;
import support.config.Configuration;

import java.util.ArrayList;
import java.util.Collection;

public class Config {

    private boolean headLess;
    private Configuration propsEnv;
    private Collection<Attachment> attachments;
    private String browser;
    private String env;

    public Config() {
        this.setPropsEnv(ConfigCache.getOrCreate(Configuration.class));
        this.setAttachments(new ArrayList<>());
        this.setHeadLess(Boolean.parseBoolean(System.getProperty("headless")));
        this.setBrowser(System.getProperty("browser"));
        this.setEnv(System.getProperty("env"));
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public boolean getHeadLess() {
        return headLess;
    }

    public void setHeadLess(boolean headLess) {
        this.headLess = headLess;
    }

    public Configuration getPropsEnv() {
        return propsEnv;
    }

    public void setPropsEnv(Configuration propsEnv) {
        this.propsEnv = propsEnv;
    }

    public Collection<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Collection<Attachment> attachments) {
        this.attachments = attachments;
    }
}
