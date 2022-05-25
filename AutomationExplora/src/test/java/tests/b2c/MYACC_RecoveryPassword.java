package tests.b2c;

import java.awt.AWTException;

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
import pages.b2c.AdobeLoginPage;
import wrappers.WebWrapper;

public class MYACC_RecoveryPassword extends setupDriver {
	
	
	
	@Test
	public static void recoveryPassword() throws UnirestException, InterruptedException, AWTException {
		startPage.startPage();
		AdobeHomePageAction.clickOnMyAccount();
		AdobeRecoveryAction.clickOnRecoveryPasswordLink();
		AdobeRecoveryAction.insertRecoveryPasswordEmail();
		AdobeRecoveryAction.clickOnRecoveryPasswordResetButton();
		Thread.sleep(5000);
		String md5 = ExternalFunction.getMd5Hash(new Configuration().emailRecovery());
		API.getRecoveryEmails(md5);
		String pass=AdobeRecoveryAction.insertRecoveryPasswordNewPassword();
		AdobeRecoveryAction.insertRecoveryPasswordConfirmPassword(pass);
		AdobeRecoveryAction.clickOnRecoveryPasswordUpdateButton();
		AdobeRecoveryAction.clickOnRecoveryPasswordUpdateSignInButton();
		
		// Login after recovery
		
		WebWrapper.typeInField(AdobeLoginPage.getLoginUsername(), new Configuration().emailRecovery());
		WebWrapper.typeInField(AdobeLoginPage.getLoginPassword(), pass);
		AdobeLoginAction.clickOnSignInButton();
		AdobeLoginAction.logOutBase();
		driver.quit();
		
		
		
		
		
	}

}
