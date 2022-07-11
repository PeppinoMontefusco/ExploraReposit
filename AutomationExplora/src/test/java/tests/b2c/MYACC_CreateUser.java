package tests.b2c;

import java.awt.AWTException;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeRegistrationAction;
import globalSetup.API;
import globalSetup.Configuration;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import globalSetup.startPageProd;
import pages.b2c.AdobeLoginPage;
import wrappers.ApachePoiStyles;
import wrappers.ExcelName;
import wrappers.OutputLine;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.WebWrapper;

@Listeners(TestListener.class) 
public class MYACC_CreateUser extends setupDriver {
	
	
	@Test
	public static void createUser() throws InterruptedException, UnirestException, AWTException{
		test=TestManager.startTest("MYACC_01", "Registration User", "MyAccount");
		startPage.startPage();
		AdobeHomePageAction.clickOnMyAccount();
		Report.passStep("Click On MyAccount");
		AdobeRegistrationAction.clickOnCreateAccountButton();
		Report.passStep("Click On Create New Account");
		String email =AdobeRegistrationAction.insertCreateAccountEmail();
		Report.passStep("Insert Email");
		AdobeRegistrationAction.insertCreateAccountPassword();
		Report.passStep("Insert Password");
		AdobeRegistrationAction.insertCreateAccountConfirmPassword();
		Report.passStep("Insert Confirm Password");
		AdobeRegistrationAction.insertCreateAccountFirstName();
		Report.passStep("Insert First Name");
		AdobeRegistrationAction.insertCreateAccountLastName();
		Report.passStep("Insert Last Name");
		AdobeRegistrationAction.insertCreateAccountDOBDay();
		AdobeRegistrationAction.insertCreateAccountDOBMonth();
		AdobeRegistrationAction.insertCreateAccountDOBYear();
		Report.passStep("Insert Date of Birth");
		AdobeRegistrationAction.setCreateAccountPrivacy1();
		Report.passStep("Click on Privacy Checkbox 1");
		AdobeRegistrationAction.setCreateAccountPrivacy2();
		Report.passStep("Click on Privacy Checkbox 2");
		AdobeRegistrationAction.clickCreateAccountSubmitButton();
		Report.passStep("Click on Submit Button");
		AdobeRegistrationAction.clickCreateAccountCloseButton();
		Report.passStep("Click on Close Button");
		Thread.sleep(3000);
		String md5=ExternalFunction.getMd5Hash(email);
		System.out.println(md5);
		API.getRegistrationEmails(md5);
		
		Report.passStep("Click on Registration link in email");
		Thread.sleep(3000);
		AdobeRegistrationAction.clickCreateAccountSuccessClose();
		Report.passStep("Click on Close in Success Popup");
		
		//Login after registration
		
		AdobeHomePageAction.clickOnMyAccount();
		Report.passStep("Click On MyAccount");
		WebWrapper.typeInField(AdobeLoginPage.getLoginUsername(), email);
		Report.passStep("Insert Email");
		AdobeLoginAction.insertLoginPassword("test");
		Report.passStep("Insert Password");
		AdobeLoginAction.clickOnSignInButton();
		Report.passStep("Click on Sign In ");
		
		AdobeLoginAction.logOutBase();
		empdata.add(new OutputLine ( ApachePoiStyles.RESULTS,List.of(email, "Nicolino2017!!!"),ExcelName.USERS));
		
		}
	
}
