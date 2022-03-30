package support.browser;

import com.microsoft.playwright.Page;
import cucumber.api.Scenario;

import java.util.logging.Logger;
import static support.context.Context.*;

public interface IBrowserManager {

    Logger log = Logger.getLogger(IBrowserManager.class.getName());

    default void tentarIrPara(String url){
        try{web().getPage().navigate(url);}
        catch (Exception e){
            log.warning(e.getMessage());
        }
    }
    default boolean pageExist(){
        return web().getBrowserContext().pages().size() < 1;
    }

    default void createNewPage(){
        int TIME_MULTIPLICATION = 1000;
        web().setPage(web().getBrowserContext().newPage());
        web().getPage().setDefaultTimeout(config().getPropsEnv().timeout() * TIME_MULTIPLICATION);
        log.info(String.format("[TAB %s] - New tab created in browser.", web().getBrowserContext().pages().size()));
    }

    default Page createAnotherPageWithoutFocus(){
        int TIME_MULTIPLICATION = 1000;
        Page newPage = web().getBrowserContext().newPage();
        newPage.setDefaultTimeout(config().getPropsEnv().timeout() * TIME_MULTIPLICATION);
        log.info(String.format("[TAB %s] - New tab created in browser.", web().getBrowserContext().pages().size()));
        return newPage;
    }

    default Page changeFocusPage(int pageNumber){
        if(pageNumber < 0 || pageNumber > web().getBrowserContext().pages().size())
            throw new IllegalStateException("Error when trying to change page focus: Page not found.");

        web().setPage(web().getBrowserContext().pages().get(pageNumber));
        log.info(String.format("Driver switched focus to %s browser tab.", (pageNumber++)));
        return web().getPage();
    }

    default void closeOtherTabs(){
        while(web().getBrowserContext().pages().size() > 1)  web().getBrowserContext().pages().get(0).close();
        changeFocusPage(0);
    }

    default void closeAllTabs(){
        while(web().getBrowserContext().pages().size() > 0)  web().getBrowserContext().pages().get(0).close();
    }

    default void finishScenario(Scenario scenario){
        if(scenario.isFailed()){
            report().takeScreenShot();
        }
        closeOtherTabs();
    }

    static void quit(){
        web().getBrowser().close();
        web().setBrowser(null);
    }
}
