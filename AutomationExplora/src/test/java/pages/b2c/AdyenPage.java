package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;

public class AdyenPage extends setupDriver {
	
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

}
