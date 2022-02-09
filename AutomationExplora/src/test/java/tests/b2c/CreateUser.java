package tests.b2c;

import org.testng.annotations.Test;

import actions.b2c.LoginAction;
import actions.b2c.RegistrationAction;
import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;

public class CreateUser extends setupDriver {
	
	
	@Test
	public static void createUser() throws InterruptedException{
		startPage.startPage();
		LoginAction.clickOnMyAccount();
	/*	RegistrationAction.clickOnCreateAccountButton();
		RegistrationAction.insertCreateAccountEmail();
		RegistrationAction.insertCreateAccountPassword();
		RegistrationAction.insertCreateAccountConfirmPassword();
		RegistrationAction.insertCreateAccountFirstName();
		RegistrationAction.insertCreateAccountLastName();
		RegistrationAction.insertCreateAccountDOBDay();
		RegistrationAction.insertCreateAccountDOBMonth();
		RegistrationAction.insertCreateAccountDOBYear();
		RegistrationAction.setCreateAccountPrivacy1();
		RegistrationAction.setCreateAccountPrivacy2();
		//RegistrationAction.clickCreateAccountSubmitButton();*/
		String ciao=ExternalFunction.getMd5Hash("ciaociao@mailkept.com");
		System.out.println(ciao);
		
		
}
	
}
