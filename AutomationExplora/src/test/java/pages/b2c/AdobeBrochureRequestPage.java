package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;

public class AdobeBrochureRequestPage extends setupDriver {
	
	public static WebElement getFirstName() {
		WebElement a = driver.findElement(By.xpath("//form[@class='form theme--light']/div[1]/div[1]/div[1]/div/input"));
		System.out.println(a.getAttribute("id"));
		return a;
		//return driver.findElement(By.cssSelector(".form.theme--light")).findElement(By.id("regFirstname"));
		}
	public static WebElement getLastName() {
		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[1]/div[1]/div[2]/div/input"));
		//return driver.findElement(By.id("regLastname"));
		}
	public static WebElement getEmail() {
		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[1]/div[2]/div[1]/div/input"));
		//return driver.findElement(By.id("regEmail"));
		}
	public static WebElement getCountryCode() {
		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[1]/div[2]/div[2]/div/div[1]/div/select"));
        //return driver.findElement(By.id("regCountryCode"));
		}
	
	public static WebElement getPhone() {
		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[1]/div[2]/div[2]/div/div[2]/div/input"));
	    //return driver.findElement(By.name("phone"));
		}
	
	public static WebElement getProvacyCheckBox() {
		return driver.findElement(By.name("privacyConsent"));
		}
	
	public static WebElement getSubmitButton() {
		return driver.findElement(By.xpath("//*[text()='Submit']"));
		}
	public static WebElement getClosetButton() {
		return driver.findElement(By.xpath("//*[text()='Close']"));
		}
	
}
