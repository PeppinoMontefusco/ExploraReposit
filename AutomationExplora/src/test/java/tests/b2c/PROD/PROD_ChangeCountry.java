package tests.b2c.PROD;

import java.awt.AWTException;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeNewsLetterAction;
import globalSetup.Configuration;
import globalSetup.setupDriver;
import globalSetup.startPage;
import globalSetup.startPageProd;
import wrappers.AdobeMethodsB2C;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;

@Listeners(TestListener.class)
public class PROD_ChangeCountry extends setupDriver  {

	@Test
	public static void AdobeChangeCountry() throws AWTException, InterruptedException{
		test=TestManager.startTest("Change Country", "Change Country", "Adobe");
		startPageProd.startPageProd();
		Report.passStep("Open Homepage");
		AdobeMethodsB2C.checkCountry(new Configuration().URLGenericProd);
		}

}