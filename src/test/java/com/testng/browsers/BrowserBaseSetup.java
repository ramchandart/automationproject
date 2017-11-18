package com.testng.browsers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BrowserBaseSetup {

    public WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "appURL"})
    public void initBrowsers(String browser, String appURL) {

        switch (browser) {
            case "chrome":
                System.out.println("Test Starts Running In Google chrome.");
                driver = new ChromeBrowser().init(appURL);
                break;

            case "firefox":
                System.out.println("Test Starts Running In Firefox.");
                driver = new FirefoxBrowser().init(appURL);
                break;

            default:
                System.out.println("browser : " + browser + " is invalid, Launching Chrome as browser of choice..");
                driver = new ChromeBrowser().init(appURL);
        }
    }
}
