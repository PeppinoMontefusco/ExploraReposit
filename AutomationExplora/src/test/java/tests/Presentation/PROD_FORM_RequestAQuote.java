package tests.Presentation;

import java.awt.AWTException;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeBrochureRequestAction;
import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeRequestAQuoteAction;
import actions.b2c.AdobeTalkWithUsAction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import globalSetup.startPageProd;
import wrappers.ApachePoiStyles;
import wrappers.ExcelName;
import wrappers.OutputLine;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class PROD_FORM_RequestAQuote extends setupDriver  {

	@Test
	public static void quote() throws AWTException, InterruptedException{
		test=TestManager.startTest("Form_Request_A_Quote", "Request a Quote", "Form");
		startPageProd.startPageProd();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnTalkToUs();
		Report.passStep("Click On Talk with Us");
		AdobeTalkWithUsAction.clickOnRequestQuoteButton();
		Report.passStep("Click On Request a Quote");
		AdobeRequestAQuoteAction.setFirstName();
		Report.passStep("Insert First Name");
		AdobeRequestAQuoteAction.setLastName();
		Report.passStep("Insert Last Name");
		AdobeRequestAQuoteAction.setPhonePrefix();
		Report.passStep("Insert Phone Prefix");
		AdobeRequestAQuoteAction.setPhone();
		Report.passStep("Insert Phone");
		String email=AdobeRequestAQuoteAction.setEmail();
		Report.passStep("Insert Email");
		AdobeRequestAQuoteAction.setQuoteSubject();
		Report.passStep("Set Quote Subject");
		AdobeRequestAQuoteAction.clickOnContactMethod();
		Report.passStep("Click on Contact Methods");
		AdobeRequestAQuoteAction.clickOnPrivacyMarketing();
		Report.passStep("Click on Privacy Marketing");
		AdobeRequestAQuoteAction.clickOnPrivacyProfiling();
		Report.passStep("Click on Privacy Profiling");
		AdobeRequestAQuoteAction.clickOnSubmitButton();
		Report.passStep("Click on Submit");
		AdobeRequestAQuoteAction.clickOnCloseButton();
		Report.passStep("Click on Close");
		empdata.add(new OutputLine ( ApachePoiStyles.RESULTS,List.of(email, "" , "Request Quote"),ExcelName.USERS));
		empdata.add(new OutputLine (ApachePoiStyles.EMPTYROW ,List.of(),ExcelName.USERS) );
		
	}
	
}
