package com.testng.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testng.browsers.BrowserBaseSetup;
import com.testng.pageobjects.LoginPage;
import com.testng.utils.ExcelUtils;

public class FB_Friends_Btn_Test extends BrowserBaseSetup {

	WebElement element;

	@BeforeClass
	public void beforeClass() {
		System.out.println("TestScript : " + FB_Friends_Btn_Test.class);
		driver = super.driver;
	}

	@Test(dataProvider = "testData")
	public void testFBfrndsBtn(String emailId, String password) throws InterruptedException {

		PageFactory.initElements(driver, LoginPage.class).loginFB(emailId, password);
		Thread.sleep(5000);

		element = driver.findElement(By.xpath("//*[@id=\"findFriendsNav\"]"));
		element.click();
		Thread.sleep(5000);
	}

	// DEFINE DATAPROVIDOR TO GET DATA FROM EXCEL
	@DataProvider(name = "testData")
	public Object[][] testDataProvidor() {
		Object[][] testDataFromExcel = ExcelUtils.readExcelData("D:\\AUTOMATION\\sampledoc.xls", "Sheet1");
		return testDataFromExcel;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
