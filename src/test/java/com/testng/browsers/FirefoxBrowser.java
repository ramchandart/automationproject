/**
 * 
 */
package com.testng.browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Raam
 *
 */
public class FirefoxBrowser {

	public WebDriver init(String appURL) {

		WebDriver driver = null;
		try {
			System.setProperty("webdriver.gecko.driver", "D:\\AUTOMATION\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

}
