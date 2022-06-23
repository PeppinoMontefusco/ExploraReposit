package pages.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.setupDriver;

public class AdobeLoginTravelAdvisorsPage extends setupDriver {

	public static WebElement getUsernameTravelAdvisors() {
		return driver.findElement(By.id("okta-signin-username"));
		
	}
	public static WebElement getPasswordTravelAdvisors() {
		return driver.findElement(By.id("okta-signin-password"));
		
		}
	public static WebElement getSignInTravelAdvisors() {
		return driver.findElement(By.id("okta-signin-submit"));
		
		}

}
