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
		test=TestManager.startTest("Form_02", "Request a Brochure", "Form");
		startPageProd.startPageProd();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnTalkToUs();
		AdobeTalkWithUsAction.clickOnRequestBrochureButton();
		AdobeBrochureRequestAction.setFirstName();
		AdobeBrochureRequestAction.setLastName();
		String email=AdobeBrochureRequestAction.setEmail();
		AdobeBrochureRequestAction.setPhonePrefix();
		AdobeBrochureRequestAction.setPhone();
		AdobeBrochureRequestAction.clickOnPrivacyCheckBox();
		AdobeBrochureRequestAction.clickOnSubmitButton();
		AdobeBrochureRequestAction.clickOnCloseButton();
		empdata.add(new OutputLine ( ApachePoiStyles.RESULTS,List.of(email, ""),ExcelName.USERS));
	}
	
}