package tests.b2c;

import java.awt.AWTException;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeNewsLetterAction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class FORM_01_NewsLetter extends setupDriver  {

	@Test
	public static void newsLetter() throws AWTException, InterruptedException{
		test=TestManager.startTest("Form_01", "NewsLetter", "Form");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnJoinUs();
		AdobeNewsLetterAction.setEmail();
		AdobeNewsLetterAction.setPhonePrefix();
		AdobeNewsLetterAction.setPhone();
		AdobeNewsLetterAction.setFirstName();
		AdobeNewsLetterAction.setLastName();
		AdobeNewsLetterAction.setCustomerType();
		AdobeNewsLetterAction.setPrivacyBox();;
		AdobeNewsLetterAction.clickOnRegisterButton();
		//AdobeNewsLetterAction.clickOnPopup();
		}

}