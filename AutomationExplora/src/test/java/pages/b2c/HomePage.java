package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;

public class HomePage extends setupDriver {

	public HomePage() {
		
	}

	public static WebElement getMyAccountButton() {
		return driver.findElements(By.className("myAccount")).get(0);
		}
	
	public static WebElement getMyAccountLoggedButton() {
		return driver.findElements(By.className("myAccountLogged")).get(0);
		}
}
