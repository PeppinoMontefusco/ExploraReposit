package tests.b2c.PROD;

import java.awt.AWTException;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeHomePageAction;

import actions.b2c.AdobeNewsLetterAction;
import globalSetup.setupDriver;

import globalSetup.startPageProd;
import wrappers.ApachePoiStyles;
import wrappers.ExcelName;
import wrappers.OutputLine;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class PROD_FORM_NewsLetter extends setupDriver  {

	@Test
	public static void newsLetter() throws AWTException, InterruptedException{
		test=TestManager.startTest("Form_01", "NewsLetter", "Form");
		startPageProd.startPageProd();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnJoinUs();
		String email =AdobeNewsLetterAction.setEmail();
		AdobeNewsLetterAction.setPhonePrefix();
		AdobeNewsLetterAction.setPhone();
		AdobeNewsLetterAction.setFirstName();
		AdobeNewsLetterAction.setLastName();
		AdobeNewsLetterAction.setCustomerType();
		AdobeNewsLetterAction.setPrivacyBox();;
		AdobeNewsLetterAction.clickOnRegisterButton();
		//AdobeNewsLetterAction.clickOnPopup();
		empdata.add(new OutputLine ( ApachePoiStyles.RESULTS,List.of(email, ""),ExcelName.USERS));
		}

}