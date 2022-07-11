package tests.Presentation;

import java.awt.AWTException;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeNewsLetterAction;
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
public class FORM_01_NewsLetter extends setupDriver  {

	@Test
	public static void newsLetter() throws AWTException, InterruptedException{
		test=TestManager.startTest("Form_01_NewsLetter", "NewsLetter", "Form");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnJoinUs();
		Report.passStep("Click On Join Us");
		String email=AdobeNewsLetterAction.setEmail();
		Report.passStep("Insert Email");
		AdobeNewsLetterAction.setPhonePrefix();
		Report.passStep("Insert Phone Prefix");
		AdobeNewsLetterAction.setPhone();
		Report.passStep("Insert Phone");
		AdobeNewsLetterAction.setFirstName();
		Report.passStep("Insert First Name");
		AdobeNewsLetterAction.setLastName();
		Report.passStep("Insert Last Name");
		AdobeNewsLetterAction.setCustomerType();
		Report.passStep("Set Customer Type");
		AdobeNewsLetterAction.setPrivacyBox();
		Report.passStep("Set Privacy flag");
		AdobeNewsLetterAction.clickOnRegisterButton();
		Report.passStep("Click on Register Button");
		AdobeNewsLetterAction.clickOnPopup();
		Report.passStep("Click on Confirmation Popup");
		
		empdata.add(new OutputLine ( ApachePoiStyles.RESULTS,List.of(email, "" , "NewsLetter"),ExcelName.USERS));
		empdata.add(new OutputLine (ApachePoiStyles.EMPTYROW ,List.of(),ExcelName.USERS) );
		}

}