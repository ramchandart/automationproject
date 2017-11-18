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
		emailId.sendKeys(email);
		password.sendKeys(pass);
		loginButton.submit();

	}

}
