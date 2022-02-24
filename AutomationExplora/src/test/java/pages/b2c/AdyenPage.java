package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;

public class AdyenPage extends setupDriver {
	
	public static WebElement getCardNumber() {
		return driver.findElement(By.id("encryptedCardNumber"));
		}

}
