package demo.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BasePage() {
	
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
			System.getProperty("user.dir") + "/src/main/java/demo/properties/Config.properties");
					prop.load(ip);
			} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
			} catch (IOException e) {
					System.out.println(e.getMessage());
			}
	}
	
	public void setUP() {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
	}

}
