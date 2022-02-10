package actions.b2c;


import globalSetup.b2c.setupDriver;
import globalSetup.b2c.Configuration;
import pages.b2c.HomePage;
import pages.b2c.RecoveryPage;
import wrappers.WebWrapper;

public class RecoveryAction extends setupDriver {
	
	public static void clickOnRecoveryPasswordLink() {
		
		WebWrapper.clickOn(RecoveryPage.getRecoveryPasswordLink());
	}
	
   public static void insertRecoveryPasswordEmail() {
		
	   WebWrapper.typeInField(RecoveryPage.getRecoveryPasswordEmail(), new Configuration().emailRecovery());
	}
   
	public static void clickOnRecoveryPasswordResetButton() {
		
		WebWrapper.clickOn(RecoveryPage.getRecoveryPasswordResetButton());
   
   
	}
}
