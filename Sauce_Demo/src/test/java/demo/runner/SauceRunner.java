package demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin= {"pretty","json:target/cucumber.json" },		
		features = {".//Features/"},
        glue = {"demo.stepdef", "demo.hooks"},	
		dryRun = false,
		monochrome = true
		)

public class SauceRunner extends AbstractTestNGCucumberTests {
	
	

}
