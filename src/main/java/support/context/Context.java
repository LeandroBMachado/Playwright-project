package support.context;

import cucumber.api.Scenario;
import support.config.Config;
import support.browser.Web;
import support.report.Report;

public class Context extends Config {

    private static Web web;
    private static Config config;
    private static Report report;
    private static Scenario scenario;

    public Context() {
        setup();
    }

    public void setup(){
        report = new Report();
        config = new Config();
        scenario = getScenario();
        if(web == null){
            web = new Web();
        }
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static void setScenario(Scenario scenario) {
        Context.scenario = scenario;
    }

    public static Report report() {
        return report;
    }

    public static Web web() {
        return web;
    }

    public static Config config() {
        return config;
    }
}
