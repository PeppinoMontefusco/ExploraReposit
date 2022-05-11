package tests.b2c;

import java.awt.AWTException;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeBrochureRequestAction;
import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeTalkWithUsAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class FORM_02_Brochure extends setupDriver  {

	@Test
	public static void brochure() throws AWTException, InterruptedException{
		test=TestManager.startTest("Form_02", "Request a Brochure", "Form");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnTalkToUs();
		AdobeTalkWithUsAction.clickOnRequestBrochureButton();
		AdobeBrochureRequestAction.setFirstName();
		AdobeBrochureRequestAction.setLastName();
		AdobeBrochureRequestAction.setEmail();
		AdobeBrochureRequestAction.setPhonePrefix();
		AdobeBrochureRequestAction.setPhone();
		AdobeBrochureRequestAction.clickOnPrivacyCheckBox();
		AdobeBrochureRequestAction.clickOnSubmitButton();
		AdobeBrochureRequestAction.clickOnCloseButton();
		
	}
	
}