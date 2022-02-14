package actions.b2c;


import globalSetup.b2c.setupDriver;
import globalSetup.b2c.Configuration;
import globalSetup.b2c.ExternalFunction;
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
	
	 public static String insertRecoveryPasswordNewPassword() {
		 String pass = "A1"+ ExternalFunction.getRandomString(7)+"!";
		 WebWrapper.typeInField(RecoveryPage.getRecoveryPasswordNewPassword(), pass);
		 return pass;
			
	 }
	 
	 public static void insertRecoveryPasswordConfirmPassword(String pass) {
		 
		 WebWrapper.typeInField(RecoveryPage.getRecoveryPasswordConfirmNewPassword(), pass);
		  }
	 
	 public static void clickOnRecoveryPasswordUpdateButton() {
			
			WebWrapper.clickOn(RecoveryPage.getRecoveryPasswordUpdatePasswordButton());
	   
	   }
	 
	 public static void clickOnRecoveryPasswordUpdateSignInButton() {
			
			WebWrapper.clickOn(RecoveryPage.getRecoveryPasswordUpdateSignInButton());
	   
	   }
	 
	 
	 
	 
	 
	 
			
		   
}
