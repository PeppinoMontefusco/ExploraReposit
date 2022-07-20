package tests;

import java.awt.AWTException;
import java.util.List;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.mashape.unirest.http.exceptions.UnirestException;
import actions.b2b.AdobeContactUsAction;
import actions.b2b.AdobeHomePageB2BAction;
import actions.b2b.AdobeLoginTravelAdvisorsAction;
import actions.b2c.AdobeHomePageAction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import globalSetup.startPageProd;
import wrappers.ApachePoiStyles;
import wrappers.ExcelName;
import wrappers.OutputLine;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.WebWrapper;

@Listeners(TestListener.class)

public class B2B_Login_And_Logout extends setupDriver {

	@Test
	public static void loginAndLogout() throws AWTException, InterruptedException, UnirestException {
		test=TestManager.startTest("Contact Us", "Contact Us", "Form");
		startPage.startPage();
		AdobeHomePageAction.clickOnTravelAdvisors();
		Report.passStep("Click On Travel Advisors");
		WebWrapper.closeAndSwitchTab();
		AdobeLoginTravelAdvisorsAction.loginBaseB2B("test");
		AdobeHomePageB2BAction.clickOnLogOut();
	    
	   

		
	}
}
