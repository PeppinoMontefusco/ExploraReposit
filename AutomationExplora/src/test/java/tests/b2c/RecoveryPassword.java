package tests.b2c;

import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.LoginAction;
import actions.b2c.RecoveryAction;
import globalSetup.b2c.Configuration;
import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;

public class RecoveryPassword extends setupDriver {
	
	
	
	@Test
	public static void recoveryPassword() throws UnirestException {
		startPage.startPage();
		LoginAction.clickOnMyAccount();
		RecoveryAction.clickOnRecoveryPasswordLink();
		RecoveryAction.insertRecoveryPasswordEmail();
		RecoveryAction.clickOnRecoveryPasswordResetButton();
		String md5 = ExternalFunction.getMd5Hash(new Configuration().emailRecovery());
		ExternalFunction.getEmails(md5);
		
	}

}
