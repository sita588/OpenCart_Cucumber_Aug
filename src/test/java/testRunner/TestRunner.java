package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features= {".//Features"},
				//features={"@target/rerun.txt"},
				glue= "stepDefinitions",
				plugin= {"pretty","html:reports/myreport.html",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"rerun:target/rerun.txt"},
				dryRun=false,
				monochrome=true,
				publish=true,
				tags="@sanity")
public class TestRunner {

}
