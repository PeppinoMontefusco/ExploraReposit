package tests.b2c;

import java.awt.AWTException;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeLoginAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class MYACC_Login_And_Logout extends setupDriver  {

	@Test
	public static void loginAndLogout() throws AWTException, InterruptedException{
		test=TestManager.startTest("MYACC_01", "Login and Logout", "MyAccount");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeLoginAction.loginBase();
		AdobeLoginAction.logOutBase();
		
		
	}

}
