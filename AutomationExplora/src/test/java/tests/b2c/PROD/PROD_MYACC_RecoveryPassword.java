package tests.b2c.PROD;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeRecoveryAction;
import globalSetup.API;
import globalSetup.Configuration;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import globalSetup.startPageProd;
import pages.b2c.AdobeLoginPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.WebWrapper;

@Listeners(TestListener.class) 
public class PROD_MYACC_RecoveryPassword extends setupDriver {
	
	
	
	@Test
	public static void Prod_recoveryPassword() throws UnirestException, InterruptedException, AWTException {
		test=TestManager.startTest("MYACC_03", "Recovery Password", "MyAccount");
		startPageProd.startPageProd();
		AdobeHomePageAction.clickOnMyAccount();
		Report.passStep("Click On MyAccount");
		AdobeRecoveryAction.clickOnRecoveryPasswordLink();
		Report.passStep("Click On Recovery Password link");
		AdobeRecoveryAction.insertRecoveryPasswordEmail();
		Report.passStep("Insert Email");
		AdobeRecoveryAction.clickOnRecoveryPasswordResetButton();
		Report.passStep("Click on Recovery Password Button");
		Thread.sleep(5000);
		String md5 = ExternalFunction.getMd5Hash(new Configuration().emailRecovery());
		API.getRecoveryEmails(md5);
		Report.passStep("Click on Recovery link in Email");
		String pass=AdobeRecoveryAction.insertRecoveryPasswordNewPassword();
		Report.passStep("Insert New Password");
		AdobeRecoveryAction.insertRecoveryPasswordConfirmPassword(pass);
		Report.passStep("Insert Confirm New Password");
		AdobeRecoveryAction.clickOnRecoveryPasswordUpdateButton();
		Report.passStep("Click on Update Button");
		AdobeRecoveryAction.clickOnRecoveryPasswordUpdateSignInButton();
		Report.passStep("Login After Recovery");
		Report.passStep("Click on Sign In Button");
	    WebWrapper.typeInField(AdobeLoginPage.getLoginUsername(), new Configuration().emailRecovery());
		Report.passStep("Insert Username");
		WebWrapper.typeInField(AdobeLoginPage.getLoginPassword(), pass);
		Report.passStep("Insert Password");
		AdobeLoginAction.clickOnSignInButton();
		Report.passStep("Click on Sign In Button");
		AdobeLoginAction.logOutBase();
		
		
		
		
		
		
	}

}
