package demo.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import demo.basepage.BasePage;
import io.cucumber.java.Scenario;

public class CommonUtilities extends BasePage {
	
	static String projectPath = "user.dir";
	
	public static WebElement getExplicitWait(WebElement elem, WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
		return element;

	}
	
	public static void waitVisibilityOfAllElements(List<WebElement> element) {
		WebDriverWait waitForFormLabel = new WebDriverWait(driver, 30);
		waitForFormLabel.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public static String getScreenshot(WebDriver driver, Scenario scenario) {

		String screenshotName = scenario.getName().replaceAll(" ", "_");
		String dateName = new SimpleDateFormat("MM.dd.yyyy-hh.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty(projectPath) + "/screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
		}
		return destination;
	}
	
	

	

}
