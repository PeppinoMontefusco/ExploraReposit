package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;

public class AdobeBrochureRequestPage extends setupDriver {
	
	public static WebElement getFirstName() {
		WebElement a = driver.findElement(By.xpath("//form[@class='form theme--light']/div[1]/div[1]/div[1]/div/input"));
		
		return a;
		
		}
	public static WebElement getLastName() {
		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[1]/div[1]/div[2]/div/input"));
		
		}
	public static WebElement getEmail() {
		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[1]/div[2]/div[1]/div/input"));
		
		}
	public static WebElement getCountryCode() {
		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[1]/div[2]/div[2]/div/div[1]/div/select"));
        
		}
	
	public static WebElement getPhone() {
		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[1]/div[2]/div[2]/div/div[2]/div/input"));
	    
		}
	
	public static WebElement getProvacyCheckBox() {
		return driver.findElement(By.name("privacyConsent"));
		}
	
	public static WebElement getSubmitButton() {
		return driver.findElement(By.xpath("//*[text()='Submit']"));
		}
	public static WebElement getClosetButton() {
		return driver.findElements(By.className("btn-full")).get(0);
		}
	
}
