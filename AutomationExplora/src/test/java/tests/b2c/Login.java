package tests.b2c;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import actions.b2c.LoginAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import pages.b2c.HomePage;
import wrappers.WebWrapper;

public class Login extends setupDriver  {

	@Test
	public static void login() throws InterruptedException {
		startPage.startPage();
		LoginAction.clickOnMyAccount();
		Thread.sleep(5000);
		WebWrapper.clickOn(HomePage.getLoginUsername());
		LoginAction.insertLoginUsername();
		LoginAction.insertLoginPassword();
		
		
	}

}
