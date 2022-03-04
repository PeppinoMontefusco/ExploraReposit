package tests.b2c;

import java.awt.AWTException;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.LoginAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;

import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class MYACC_Login_And_Logout extends setupDriver  {

	@Test
	public static void loginAndLogout() throws AWTException, InterruptedException{
		test=TestManager.startTest("Log_01", "Booking Flow 2 adult 1 child - Create Option Not Logged", "MyAccount");
		startPage.startPage();
		LoginAction.loginBase();
		LoginAction.logOutBase();
		
		
	}

}
