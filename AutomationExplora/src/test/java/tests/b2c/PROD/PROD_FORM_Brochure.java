package tests.b2c.PROD;

import java.awt.AWTException;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeBrochureRequestAction;
import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeTalkWithUsAction;
import globalSetup.setupDriver;
import globalSetup.startPageProd;
import wrappers.ApachePoiStyles;
import wrappers.ExcelName;
import wrappers.OutputLine;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class PROD_FORM_Brochure extends setupDriver  {

	@Test
	public static void brochure() throws AWTException, InterruptedException{
		test=TestManager.startTest("Form_Brochure", "Request a Brochure", "Form");
		startPageProd.startPageProd();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnTalkToUs();
		Report.passStep("Click On Talk with Us");
		AdobeTalkWithUsAction.clickOnRequestBrochureButton();
		Report.passStep("Click On Request Brochure");
		AdobeBrochureRequestAction.setFirstName();
		Report.passStep("Insert First Name");
		AdobeBrochureRequestAction.setLastName();
		Report.passStep("Insert Last Name");
		String email=AdobeBrochureRequestAction.setEmail();
		Report.passStep("Insert Email");
		AdobeBrochureRequestAction.setPhonePrefix();
		Report.passStep("Insert Phone Prefix");
		AdobeBrochureRequestAction.setPhone();
		Report.passStep("Insert Phone");
		AdobeBrochureRequestAction.clickOnPrivacyCheckBox();
		Report.passStep("Click on Check Box");
		AdobeBrochureRequestAction.clickOnSubmitButton();
		Report.passStep("Click on Submit Button");
		AdobeBrochureRequestAction.clickOnCloseButton();
		Report.passStep("Click on Close Button");
		empdata.add(new OutputLine ( ApachePoiStyles.RESULTS,List.of(email, "Form_Brochure"),ExcelName.USERS));
	}
	
}