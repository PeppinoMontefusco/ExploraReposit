package tests.b2c;

import java.awt.AWTException;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeBrochureRequestAction;
import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeRequestAQuoteAction;
import actions.b2c.AdobeTalkWithUsAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class FORM_03_RequestAQuote extends setupDriver  {

	@Test
	public static void quote() throws AWTException, InterruptedException{
		test=TestManager.startTest("Form_03", "Request a Quote", "Form");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnTalkToUs();
		AdobeTalkWithUsAction.clickOnRequestQuoteButton();
		AdobeRequestAQuoteAction.setFirstName();
		AdobeRequestAQuoteAction.setLastName();
		AdobeRequestAQuoteAction.setPhonePrefix();
		AdobeRequestAQuoteAction.setPhone();
		AdobeRequestAQuoteAction.setEmail();
		AdobeRequestAQuoteAction.setQuoteSubject();
		AdobeRequestAQuoteAction.clickOnContactMethod();
		AdobeRequestAQuoteAction.clickOnPrivacyMarketing();
		AdobeRequestAQuoteAction.clickOnPrivacyProfiling();
		AdobeRequestAQuoteAction.clickOnSubmitButton();
		AdobeRequestAQuoteAction.clickOnCloseButton();
		
		
	}
	
}
