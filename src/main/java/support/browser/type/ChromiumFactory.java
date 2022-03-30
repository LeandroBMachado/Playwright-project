package support.browser.type;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import static support.context.Context.*;


public class ChromiumFactory{
    public static void createInstance() {
        web().setBrowser(Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(config().getHeadLess())));
        web().setBrowserContext(web().getBrowser().newContext());
    }
}