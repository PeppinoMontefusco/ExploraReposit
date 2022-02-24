package tests.b2c;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.HomePageAction;
import actions.b2c.LoginAction;
import actions.b2c.RecoveryAction;
import globalSetup.b2c.Configuration;
import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import pages.b2c.LoginPage;
import wrappers.WebWrapper;

public class RecoveryPassword extends setupDriver {
	
	
	
	@Test
	public static void recoveryPassword() throws UnirestException, InterruptedException, AWTException {
		startPage.startPage();
		HomePageAction.clickOnMyAccount();
		RecoveryAction.clickOnRecoveryPasswordLink();
		RecoveryAction.insertRecoveryPasswordEmail();
		RecoveryAction.clickOnRecoveryPasswordResetButton();
		Thread.sleep(5000);
		String md5 = ExternalFunction.getMd5Hash(new Configuration().emailRecovery());
		ExternalFunction.getRecoveryEmails(md5);
		String pass=RecoveryAction.insertRecoveryPasswordNewPassword();
		RecoveryAction.insertRecoveryPasswordConfirmPassword(pass);
		RecoveryAction.clickOnRecoveryPasswordUpdateButton();
		RecoveryAction.clickOnRecoveryPasswordUpdateSignInButton();
		
		// Login after recovery
		
		WebWrapper.typeInField(LoginPage.getLoginUsername(), new Configuration().emailRecovery());
		WebWrapper.typeInField(LoginPage.getLoginPassword(), pass);
		LoginAction.clickOnSignInButton();
		LoginAction.logOutBase();
		driver.quit();
		
		
		
		
	}

}
