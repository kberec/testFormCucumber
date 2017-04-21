package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature",
		glue={"stepDefinition"},
		plugin={"html:target/cucumber-html-report","json:target/cucumber-report.json" }
		)
public class TestRunner {

}
