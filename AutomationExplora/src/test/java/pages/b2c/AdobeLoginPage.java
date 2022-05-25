package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import globalSetup.setupDriver;
import wrappers.WebWrapper;

public class AdobeLoginPage extends setupDriver {

	public AdobeLoginPage() {
		
	}

	public static WebElement getLoginUsername() {
		 //WebWrapper.wait.until(ExpectedConditions.elementToBeClickable(By.id("okta-signin-username")));
		 //WebWrapper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okta-signin-username")));
		return driver.findElement(By.id("okta-signin-username"));
		}
	public static WebElement getLoginPassword() {
		return driver.findElement(By.id("okta-signin-password"));
		}
	public static WebElement getSignInButton() {
		
		return driver.findElement(By.id("okta-signin-submit"));
		}
	public static WebElement getSignOutButton() {
		return driver.findElement(By.xpath("//a[@title='Sign out']"));
	}
	
	
	
	
    
    
}
