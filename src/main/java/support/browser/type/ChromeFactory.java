package support.browser.type;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import static support.context.Context.*;

public class ChromeFactory {
    public static void createInstance() {
        web().setBrowser(Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(config().getHeadLess())));
        web().setBrowserContext(web().getBrowser().newContext());
    }
}
