package support.browser.type;

import com.microsoft.playwright.Playwright;
import static support.context.Context.*;


public class RemoteFactory {

    public static void createInstance(String urlConnect) {
        web().setBrowser(Playwright.create().chromium().connectOverCDP(urlConnect));
        web().setBrowserContext(web().getBrowser().newContext());
    }
    public static void createInstance() {
        web().setBrowser(Playwright.create().chromium().connectOverCDP(config().getPropsEnv().urlRemote()));
        web().setBrowserContext(web().getBrowser().newContext());
    }
}
