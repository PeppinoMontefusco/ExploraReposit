package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.setupDriver;

public class TouchXAdyenPage extends setupDriver {
	
	public static WebElement getCardNumber() {
		return driver.findElement(By.id("encryptedCardNumber"));
		}
	
	public static WebElement getExpityDate() {
		return driver.findElement(By.id("encryptedExpiryDate"));
		}
	
	public static WebElement getCVV() {
		return driver.findElement(By.id("encryptedSecurityCode"));
		}
	
	public static WebElement getPayButton() {
		return driver.findElements(By.className("adyen-checkout__button--pay")).get(0);
		}
	
	public static WebElement getAmount() {
		return driver.findElements(By.className("adyen-checkout__button__text")).get(0);
	}
	public static WebElement getUsername3DS1() {
		return driver.findElement(By.id("username"));
	}
	
	public static WebElement getPassword3DS1() {
		return driver.findElement(By.id("password"));
	}
	public static WebElement getPayButton3DS1() {
		return driver.findElements(By.className("paySubmit")).get(0);
		}
	
	public static WebElement getPassword3DS2() {
		return driver.findElements(By.className("input-field")).get(0);
	}
	
	public static WebElement getSubmitButton3DS2() {
		return driver.findElement(By.id("buttonSubmit"));
	}
}
	
