package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import globalSetup.b2c.setupDriver;
import wrappers.WebWrapper;

public class TouchXLoginPage extends setupDriver {
	
	public static WebElement getUsername() {
	
	return driver.findElement(By.id("okta-signin-username"));
	}
	
	public static WebElement getPassword() {
		
		return driver.findElement(By.id("okta-signin-password"));
		}
	
	public static WebElement getSignInButton() {
		
		return driver.findElement(By.id("okta-signin-submit"));
		}
	
}


