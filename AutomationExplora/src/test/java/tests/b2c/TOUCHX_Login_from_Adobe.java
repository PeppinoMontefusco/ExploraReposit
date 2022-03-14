package tests.b2c;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import globalSetup.b2c.Configuration;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class TOUCHX_Login_from_Adobe extends setupDriver {
	
	@Test
	public static void loginFromAdobe() throws AWTException, InterruptedException{
		test=TestManager.startTest("INT_01", "Login from Adobe", "Integration");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeLoginAction.loginBase();
		Thread.sleep(2000);
		AdobeHomePageAction.clickOnQuickSearch();
		WebWrapper.waitForJavascript();
		Thread.sleep(2000);
		VersonixMethodsB2C.searchTextFromSpan(new Configuration().name());
		

}
}