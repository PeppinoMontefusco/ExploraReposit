package tests.b2c;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import globalSetup.Configuration;
import globalSetup.setupDriver;
import globalSetup.startPage;
import pages.b2c.AdobeHomePage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class TOUCHX_Login_from_Adobe extends setupDriver {
	
	@Test
	public static void integrationAdobeVersonixLoginLogout() throws AWTException, InterruptedException{
		test=TestManager.startTest("INT_01", "Login from Adobe", "Integration");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeLoginAction.loginBase("test");
		WebWrapper.waitForJavascript();
		AdobeHomePageAction.clickOnQuickSearch();
		Report.passStep("Click On Quick Search");
		WebWrapper.waitForJavascript();
		Thread.sleep(10000);
		VersonixMethodsB2C.searchTextFromSpan(new Configuration().name());
		Report.passStep("Integration Login Adobe - TouchX");
		VersonixMethodsB2C.searchTagNotClickableAndClick("VersonixIcons","span");
		Report.passStep("Click On My Profile Icon in TouchX");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagAndClickByOffset("width: 168px", "flt-clip", 80, 10);
		Report.passStep("Click On Sign Out in Touch X");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagAndClick("width: 92.8px","flt-clip");
		Report.passStep("Close Sign Out Pop Up");
		VersonixMethodsB2C.startVersonixPage();
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.clickOnLabel("Back");
		Report.passStep("Return in Adobe");
		WebWrapper.waitForJavascript();
		if(AdobeHomePage.getMyAccountButton().isDisplayed()) {
			Report.passStep("User Is Not Logged");
		}
		else
		{
			throw new RuntimeException("User Still Logged");
		}
		

}
}