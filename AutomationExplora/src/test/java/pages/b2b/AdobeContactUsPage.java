package pages.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.ExternalFunction;
import globalSetup.setupDriver;

public class AdobeContactUsPage extends setupDriver {
	
	
	public static WebElement getFirstName() {
		return driver.findElement(By.id("regFirstname"));
		
		}
	
	public static WebElement getLastName() {
		return driver.findElement(By.id("regLastname"));
		
		}
	
	public static WebElement getEmail() {
		return driver.findElement(By.id("regEmail"));
		
		}
	public static WebElement getCountryCode() {
		return driver.findElement(By.id("regCountryCode"));
		
		}
	
	public static WebElement getPhone() {
		return driver.findElement(By.name("phone"));
		
		}
	
	public static WebElement getTopic() {
		String n =ExternalFunction.getRandomInt(0, 2);
		int num = Integer.parseInt(n);
		return driver.findElements(By.name("topic")).get(num);
		
		}
	public static WebElement getMessageBox() {
		return driver.findElement(By.id("contactUsMessage"));
		
		}
	public static WebElement getSendButton() {
		return driver.findElements(By.className("cta-navy-btn")).get(2);
		
		}
	public static WebElement getBackButton() {
		return driver.findElements(By.className("w-ml-100-imp")).get(0);
		
		}
	
	
	
}
