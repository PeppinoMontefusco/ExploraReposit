package tests.b2c;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeRegistrationAction;
import globalSetup.b2c.Configuration;
import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import pages.b2c.AdobeLoginPage;
import wrappers.WebWrapper;

public class CreateUser extends setupDriver {
	
	
	@Test
	public static void createUser() throws InterruptedException, UnirestException, AWTException{
		startPage.startPage();
		AdobeHomePageAction.clickOnMyAccount();
		AdobeRegistrationAction.clickOnCreateAccountButton();
		String email =AdobeRegistrationAction.insertCreateAccountEmail();
		//Gestire la pausa all'interno del metodo insertCreateAccountEmail() in quando risulta la form non formattata correttamente
		
		AdobeRegistrationAction.insertCreateAccountPassword();
		AdobeRegistrationAction.insertCreateAccountConfirmPassword();
		AdobeRegistrationAction.insertCreateAccountFirstName();
		AdobeRegistrationAction.insertCreateAccountLastName();
		AdobeRegistrationAction.insertCreateAccountDOBDay();
		AdobeRegistrationAction.insertCreateAccountDOBMonth();
		AdobeRegistrationAction.insertCreateAccountDOBYear();
		AdobeRegistrationAction.setCreateAccountPrivacy1();
		AdobeRegistrationAction.setCreateAccountPrivacy2();
		AdobeRegistrationAction.clickCreateAccountSubmitButton();
		AdobeRegistrationAction.clickCreateAccountCloseButton();
		String md5=ExternalFunction.getMd5Hash(email);
		ExternalFunction.getRegistrationEmails(md5);
		AdobeRegistrationAction.clickCreateAccountSuccessClose();
		
		//Login after registration
		
		AdobeHomePageAction.clickOnMyAccount();
		WebWrapper.typeInField(AdobeLoginPage.getLoginUsername(), email);
		AdobeLoginAction.insertLoginPassword();
		AdobeLoginAction.clickOnSignInButton();
		
		AdobeLoginAction.logOutBase();
		driver.quit();
		
		}
	
}
