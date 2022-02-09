package tests.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import actions.b2c.LoginAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import pages.b2c.HomePage;
import wrappers.WebWrapper;

public class LoginAndLogout extends setupDriver  {

	@Test
	public static void loginAndLogout(){
		startPage.startPage();
		LoginAction.loginBase();
		LoginAction.logOutBase();
		driver.quit();
		
	}

}