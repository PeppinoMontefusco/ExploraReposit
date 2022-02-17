package tests.b2c;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.LoginAction;
import actions.b2c.RegistrationAction;
import globalSetup.b2c.Configuration;
import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import pages.b2c.HomePage;
import wrappers.WebWrapper;

public class CreateUser extends setupDriver {
	
	
	@Test
	public static void createUser() throws InterruptedException, UnirestException, AWTException{
		startPage.startPage();
		LoginAction.clickOnMyAccount();
		RegistrationAction.clickOnCreateAccountButton();
		String email =RegistrationAction.insertCreateAccountEmail();
		//Gestire la pausa all'interno del metodo insertCreateAccountEmail() in quando risulta la form non formattata correttamente
		
		RegistrationAction.insertCreateAccountPassword();
		RegistrationAction.insertCreateAccountConfirmPassword();
		RegistrationAction.insertCreateAccountFirstName();
		RegistrationAction.insertCreateAccountLastName();
		RegistrationAction.insertCreateAccountDOBDay();
		RegistrationAction.insertCreateAccountDOBMonth();
		RegistrationAction.insertCreateAccountDOBYear();
		RegistrationAction.setCreateAccountPrivacy1();
		RegistrationAction.setCreateAccountPrivacy2();
		RegistrationAction.clickCreateAccountSubmitButton();
		RegistrationAction.clickCreateAccountCloseButton();
		String md5=ExternalFunction.getMd5Hash(email);
		ExternalFunction.getRegistrationEmails(md5);
		RegistrationAction.clickCreateAccountSuccessClose();
		
		//Login after registration
		
		LoginAction.clickOnMyAccount();
		WebWrapper.typeInField(HomePage.getLoginUsername(), email);
		LoginAction.insertLoginPassword();
		LoginAction.clickOnSignInButton();
		
		LoginAction.logOutBase();
		driver.quit();
		
		}
	
}
