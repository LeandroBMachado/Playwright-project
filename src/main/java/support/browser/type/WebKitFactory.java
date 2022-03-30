package support.browser.type;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import static support.context.Context.*;


public class WebKitFactory {
    public static void createInstance() {
        web().setBrowser(Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(config().getHeadLess())));
        web().setBrowserContext(web().getBrowser().newContext());
    }
}
