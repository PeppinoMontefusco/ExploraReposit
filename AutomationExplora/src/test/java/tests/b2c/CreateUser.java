package tests.b2c;

import org.testng.annotations.Test;

import actions.b2c.LoginAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;

public class CreateUser extends setupDriver {
	
	
	@Test
	public static void createUser() throws InterruptedException{
		startPage.startPage();
		LoginAction.clickOnMyAccount();
		LoginAction.clickOnCreateAccountButton();
		Thread.sleep(2000);
		LoginAction.insertCreateAccountEmail();
		LoginAction.insertCreateAccountPassword();
		LoginAction.insertCreateAccountConfirmPassword();
		LoginAction.insertCreateAccountFirstName();
		LoginAction.insertCreateAccountLastName();
		LoginAction.insertCreateAccountDOBYear();
		LoginAction.setCreateAccountPrivacy1();
		LoginAction.setCreateAccountPrivacy2();
		//LoginAction.clickCreateAccountSubmitButton();
		
		
}
	
}
