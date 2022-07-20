package actions.b2c;


import globalSetup.Configuration;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import pages.b2c.AdobeLoginPage;
import pages.b2c.AdobeRecoveryPage;
import wrappers.WebWrapper;

public class AdobeRecoveryAction extends setupDriver {
	
	public static void clickOnRecoveryPasswordLink() {
		
		WebWrapper.clickOn(AdobeRecoveryPage.getRecoveryPasswordLink());
	}
	
   public static void insertRecoveryPasswordEmail(String env) {
	   if (env.equalsIgnoreCase("test")) {
	    	
		   WebWrapper.typeInField(AdobeRecoveryPage.getRecoveryPasswordEmail(), new Configuration().emailRecovery());
	    	} else if(env.equalsIgnoreCase("prod")) {
	    		WebWrapper.typeInField(AdobeRecoveryPage.getRecoveryPasswordEmail(), new Configuration().emailRecoveryProd());
	    	}else
	    	{
	    		throw new RuntimeException("Wrong Environment");
	    	}
	}
   
	public static void clickOnRecoveryPasswordResetButton() throws InterruptedException {
		
		WebWrapper.clickOn(AdobeRecoveryPage.getRecoveryPasswordResetButton());
		Thread.sleep(5000);
   
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
