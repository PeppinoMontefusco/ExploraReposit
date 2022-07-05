package tests.b2c;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
import actions.b2c.TouchXLoginAction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)

public class TOUCHX_Login_And_Logout extends setupDriver {
	
	
	@Test
	public static void loginAndLogout() throws InterruptedException, AWTException {
		test=TestManager.startTest("TOUCHX_01",  "Login and Logout", "TouchX - My Account");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		AdobeSearchCruiseAction.clickOnDestination();
		Report.passStep("Select One Destination");
		AdobeSearchCruiseAction.clickOnSelectAndCloseDestination();
		Report.passStep("Click On Select And Close");
		AdobeSearchCruiseAction.clickSearchCruise();
		Report.passStep("Click On Search Cruise");
		WebWrapper.waitForJavascript();
		TouchXLoginAction.loginBaseTouchX();
		Thread.sleep(3000);
		VersonixMethodsB2C.searchTagNotClickableAndClick("VersonixIcons","span");
		Report.passStep("Click On My Profile Icon");
		Thread.sleep(2000);
		VersonixMethodsB2C.searchTagAndClickByOffset("width: 168px", "flt-clip", 80, 10);
		Report.passStep("Click On Sign Out");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagAndClick("width: 92.8px","flt-clip");
		Report.passStep("Close Sign Out Pop Up");
		
		    
		
		
}
}