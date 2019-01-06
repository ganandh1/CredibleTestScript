package cucumberFramework.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)

@CucumberOptions (
		features = {"src/test/java/cucumberFramework/feature"},
		glue = {"cucumberFramework.steps"},
		monochrome = true,
		tags = {},
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
		)

public class MainRunner {


}
