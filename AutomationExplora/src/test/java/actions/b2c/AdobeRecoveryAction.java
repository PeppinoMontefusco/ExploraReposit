package actions.b2c;


import globalSetup.Configuration;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import pages.b2c.AdobeRecoveryPage;
import wrappers.WebWrapper;

public class AdobeRecoveryAction extends setupDriver {
	
	public static void clickOnRecoveryPasswordLink() {
		
		WebWrapper.clickOn(AdobeRecoveryPage.getRecoveryPasswordLink());
	}
	
   public static void insertRecoveryPasswordEmail() {
		
	   WebWrapper.typeInField(AdobeRecoveryPage.getRecoveryPasswordEmail(), new Configuration().emailRecovery());
	}
   
	public static void clickOnRecoveryPasswordResetButton() {
		
		WebWrapper.clickOn(AdobeRecoveryPage.getRecoveryPasswordResetButton());
   
   }
	
	 public static String insertRecoveryPasswordNewPassword() {
		 String pass = "A1"+ ExternalFunction.getRandomString(7)+"!";
		 WebWrapper.typeInField(AdobeRecoveryPage.getRecoveryPasswordNewPassword(), pass);
		 return pass;
			
	 }
	 
	 public static void insertRecoveryPasswordConfirmPassword(String pass) {
		 
		 WebWrapper.typeInField(AdobeRecoveryPage.getRecoveryPasswordConfirmNewPassword(), pass);
		  }
	 
	 public static void clickOnRecoveryPasswordUpdateButton() {
			
			WebWrapper.clickOn(AdobeRecoveryPage.getRecoveryPasswordUpdatePasswordButton());
	   
	   }
	 
	 public static void clickOnRecoveryPasswordUpdateSignInButton() {
			
			WebWrapper.clickOn(AdobeRecoveryPage.getRecoveryPasswordUpdateSignInButton());
	   
	   }
	 
	 
	 
	 
	 
	 
			
		   
}
