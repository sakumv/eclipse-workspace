package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.*;


@RunWith(Cucumber.class) 
@CucumberOptions(
		features = "src/test/java/feature",
		glue = {"stepDefinitions"}
		//,	tags = "@deletePlace"
		,plugin= "json:target/jsonReport/cucumber-report.json"
		)

public class TestRunner {

}
