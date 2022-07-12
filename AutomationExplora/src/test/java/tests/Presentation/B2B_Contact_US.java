package tests.Presentation;

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
import wrappers.ApachePoiStyles;
import wrappers.ExcelName;
import wrappers.OutputLine;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.WebWrapper;

@Listeners(TestListener.class)

public class B2B_Contact_US extends setupDriver {

	@Test
	public static void loginTravelAdvisors() throws AWTException, InterruptedException, UnirestException {
		test=TestManager.startTest("Contact Us", "Contact Us", "Form");
		startPage.startPage();
		AdobeHomePageAction.clickOnTravelAdvisors();
		Report.passStep("Click On Travel Advisors");
		WebWrapper.closeAndSwitchTab();
		AdobeLoginTravelAdvisorsAction.loginBaseB2B();
	    AdobeHomePageB2BAction.clickOnContactUs();
	    Report.passStep("Click On Contact Us");
	    AdobeContactUsAction.setFirstName();
	    Report.passStep("Insert First Name");
	    AdobeContactUsAction.setLastName();
	    Report.passStep("Insert Last Name");
	    String email =AdobeContactUsAction.setEmail();
	    Report.passStep("Insert Email");
	    AdobeContactUsAction.selectCountryCode();
	    Report.passStep("Select Country Code");
	    AdobeContactUsAction.setPhone();
	    Report.passStep("Insert Phone Number");
	    AdobeContactUsAction.setTopic();
	    Report.passStep("Set Topic");
	    AdobeContactUsAction.setMessage();
	    Report.passStep("Insert Message");
	    AdobeContactUsAction.clickOnSend();
	    Report.passStep("Click On Send Button");
	    AdobeContactUsAction.clickOnBack();
	    Report.passStep("Click On Back Button");
	    empdata.add(new OutputLine ( ApachePoiStyles.RESULTS,List.of(email, "",  "Contact Us"),ExcelName.USERS));
	    empdata.add(new OutputLine (ApachePoiStyles.EMPTYROW ,List.of("" , "" ,"" ),ExcelName.USERS) );

		
	}
}
