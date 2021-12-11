package demo.hooks;

import demo.basepage.BasePage;
import demo.utility.CommonUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BasePage {
	
	public Scenario scenario;
	
	@Before
	public void suiteSetup(Scenario scenario) throws InterruptedException {
		this.scenario = scenario; 
		setUP();

	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			CommonUtilities.getScreenshot(driver, scenario);
		}
		driver.close();
		driver.quit();

	}

}
