package tests.Presentation;

import java.awt.AWTException;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeLoginAction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import globalSetup.startPageProd;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class PROD_MYACC_Login_And_Logout extends setupDriver  {

	@Test
	public static void loginAndLogout() throws AWTException, InterruptedException{
		test=TestManager.startTest("MYACC_02", "Login and Logout", "MyAccount");
		startPageProd.startPageProd();
		Report.passStep("Open Homepage");
		AdobeLoginAction.loginBase("prod");
		AdobeLoginAction.logOutBase();
		
		
	}

}
