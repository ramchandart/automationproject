/**
 * 
 */
package com.testng.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * @author Raam
 *
 */
public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/*private By emailId = By.id("email");
	private By password = By.name("pass");
	private By loginButton = By.xpath(".//*[@id='u_0_5']");*/
	
	@FindBy(id="email") 
	@CacheLookup
	WebElement emailId; 
	 
	@FindBy(name="pass")
	@CacheLookup
	WebElement password;
	 
	@FindBy(xpath=".//*[@id='u_0_5']")
	@CacheLookup
	WebElement loginButton;
	 
	
	public void loginFB(String email, String pass) {

		/*driver.findElement(emailId).sendKeys(email);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).submit();*/
		
		emailId.sendKeys(email);
		password.sendKeys(pass);
		loginButton.submit();

	}

}
