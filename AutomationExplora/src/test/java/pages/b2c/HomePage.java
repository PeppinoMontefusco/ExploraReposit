package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import globalSetup.b2c.setupDriver;
import wrappers.WebWrapper;

public class HomePage extends setupDriver {

	public HomePage() {
		
	}

	public static WebElement getMyAccountButton() {
		return driver.findElements(By.className("myAccount")).get(0);
		}
	
	public static WebElement getMyAccountLoggedButton() {
		 WebWrapper.wait.until(ExpectedConditions.elementToBeClickable(By.className("myAccountLogged")));
		 WebWrapper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("myAccountLogged")));
		return driver.findElements(By.className("myAccountLogged")).get(0);
		}
	public static WebElement getLoginUsername() {
		 WebWrapper.wait.until(ExpectedConditions.elementToBeClickable(By.id("okta-signin-username")));
		 WebWrapper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okta-signin-username")));
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
	
	public static WebElement getBookAJourneyButton() {
		return driver.findElements(By.className("cta")).get(0);
	}
	
	
	
	
    
    
}
