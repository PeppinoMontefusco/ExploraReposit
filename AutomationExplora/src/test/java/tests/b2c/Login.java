package tests.b2c;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import actions.b2c.LoginAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.WebWrapper;

public class Login extends setupDriver  {

	@Test
	public static void login() {
		startPage.startPage();
		//WebWrapper.clickOn(driver.findElement(By.id("didomi-notice-agree-button")));
		driver.findElement(By.id("didomi-notice-agree-button")).click();
		LoginAction.clickOnMyAccount();
		
		
	}

}
