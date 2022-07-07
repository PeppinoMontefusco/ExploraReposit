package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import globalSetup.ExternalFunction;
import globalSetup.setupDriver;

public class AdobeNewsLetterPage extends setupDriver {
	
	
	public static WebElement getEmailField() {
		return driver.findElements(By.name("email")).get(0);
		}
	
	public static WebElement getPhonePrefix() {
		return driver.findElement(By.id("regCountryCode"));
		}

	public static WebElement getPhoneField() {
		return driver.findElements(By.name("phone")).get(0);
		}
	
	public static WebElement getFirstNameField() {
		return driver.findElements(By.name("firstName")).get(0);
		}
	
	public static WebElement getLastNameField() {
		return driver.findElements(By.name("lastName")).get(0);
		}
	
	public static WebElement getCustomerCheckBox() {
		String prefix= ExternalFunction.getRandomInt(0, 2);
		int code = Integer.parseInt(prefix);
		return driver.findElements(By.name("customerType")).get(code);
		}
	public static WebElement getPrivacyCheckBox() {
		return driver.findElements(By.name("privacyProfilingConsent")).get(0);
		}
	
	public static WebElement getRegisterButton() {
		return driver.findElement(By.xpath("//*[text()='register']"));
		}
	public static WebElement getPopupButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.querySelector('[aria-label=\"Close overlay\"]').click();");
		return driver.findElements(By.cssSelector(".cta-navy-btn.space-left--auto.space-right--auto")).get(2);
		//return driver.findElement(By.className("cta-navy-btn"))
		}
	
	 
}
