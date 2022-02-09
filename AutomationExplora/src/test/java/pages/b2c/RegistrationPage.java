package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import globalSetup.b2c.setupDriver;
import wrappers.WebWrapper;

public class RegistrationPage extends setupDriver {
	
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
    
    public static WebElement getCreateAccountDOBDay() {
		
		return driver.findElements(By.name("dateOfBirth_day")).get(0);
	}
    
    public static WebElement getCreateAccountDOBMonth() {
	
	return driver.findElements(By.name("dateOfBirth_month")).get(0);
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
