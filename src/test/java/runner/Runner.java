package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import support.browser.IBrowserManager;
import support.report.server.controller.ActionController;


@RunWith(Cucumber.class)
@CucumberOptions(
		 tags = {"@loginGiu"},
		 glue = {"hooks", "steps"},
		 plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm",
				 	"pretty","json:target/json-cucumber-reports/cucumber.json",
				 	"junit:target/xml-junit/junit.xml"},
		features = {"src/test/resources/features"})
public class Runner{

	@AfterClass
	public static void tearDownAll(){
		IBrowserManager.quit();
		new ActionController().sendResults();
	}
}
