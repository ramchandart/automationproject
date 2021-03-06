package com.testng.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testng.browsers.BrowserBaseSetup;
import com.testng.pageobjects.LoginPage;
import com.testng.utils.ExcelUtils;

public class FB_Login_Test extends BrowserBaseSetup {

	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("TestScript :"+FB_Login_Test.class);
		driver=super.driver;
	}

	@Test(dataProvider = "testData")
	public void testFBLoginPage(String emailId, String password) throws InterruptedException {

		PageFactory.initElements(driver, LoginPage.class).loginFB(emailId, password);
		Thread.sleep(3000);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	// DEFINE DATAPROVIDOR TO GET DATA FROM EXCEL
	@DataProvider(name = "testData")
	public Object[][] testDataProvidor() {
		Object[][] testDataFromExcel = ExcelUtils.readExcelData("D:\\AUTOMATION\\sampledoc.xls", "Sheet1");
		return testDataFromExcel;
	}

}
