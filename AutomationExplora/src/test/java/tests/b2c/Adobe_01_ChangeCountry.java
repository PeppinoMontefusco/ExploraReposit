package tests.b2c;

import java.awt.AWTException;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeNewsLetterAction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import wrappers.AdobeMethodsB2C;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class Adobe_01_ChangeCountry extends setupDriver  {

	@Test
	public static void AdobeChangeCountry() throws AWTException, InterruptedException{
		test=TestManager.startTest("Change Country", "Change Country", "Adobe");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeMethodsB2C.checkCountry();
		}

}