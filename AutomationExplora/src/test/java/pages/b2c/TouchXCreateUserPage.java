package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import globalSetup.setupDriver;
import wrappers.WebWrapper;

public class TouchXCreateUserPage extends setupDriver {
	
	public static WebElement getCreateUserButton() {
	
	return driver.findElements(By.className("sign-up")).get(0);
	}
	
	
	
}


