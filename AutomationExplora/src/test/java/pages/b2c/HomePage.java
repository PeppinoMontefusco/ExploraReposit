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
	
	public static WebElement getCreateAccountButton() {
		return driver.findElements(By.className("oktaWidget__tab")).get(0);
	}
	
	public static WebElement getCreateAccountEmail() {
		
		//WebWrapper.wait.until(ExpectedConditions.invisibilityOfAllElements(By.className("o-form-fieldset-container")));
		WebWrapper.wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
		 WebWrapper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		 
		return driver.findElements(By.name("email")).get(0);
	}
	
	public static WebElement getCreateAccountPassword() {
		
		return driver.findElements(By.name("password")).get(0);
	}
	public static WebElement getCreateAccountConfirmPassword() {
		
		return driver.findElements(By.name("confirmPassword")).get(0);
	}
	
    public static WebElement getCreateAccountFirstName() {
		
		return driver.findElements(By.name("firstName")).get(0);
	}
    public static WebElement getCreateAccountLastName() {
		
		return driver.findElements(By.name("lastName")).get(0);
	}
    
    public static WebElement getCreateAccountDOBYear() {
		
		return driver.findElements(By.name("dateOfBirth_year")).get(0);
	}
    
    public static WebElement getCreateAccountPrivacy1() {
		
		return driver.findElements(By.name("privacyCheckbox0")).get(0);
	}
    
    public static WebElement getCreateAccountPrivacy2() {
		
  		return driver.findElements(By.name("privacyCheckbox1")).get(0);
  	}
    
public static WebElement getCreateAccountSubmitButton() {
		
  		return driver.findElements(By.className("button-primary")).get(0);
  	}
    
    
}
