package actions.b2c;

import globalSetup.Configuration;
import pages.b2c.AdobeLoginPage;
import wrappers.Report;
import wrappers.WebWrapper;

public class AdobeLoginAction  {

	
	public static void insertLoginUsername(String env) {
		if (env.equalsIgnoreCase("test")) {
	    	
	    	WebWrapper.typeInField(AdobeLoginPage.getLoginUsername(), new Configuration().username());
	    	} else if(env.equalsIgnoreCase("prod")) {
	    	WebWrapper.typeInField(AdobeLoginPage.getLoginUsername(), new Configuration().usernameProd());
	    	}else
	    	{
	    		throw new RuntimeException("Wrong Environment");
	    	}
    }
	
    
    public static void insertLoginPassword(String env) {
    	if (env.equalsIgnoreCase("test")) {
    	WebWrapper.typeInField(AdobeLoginPage.getLoginPassword(), new Configuration().password());
    	} else if(env.equalsIgnoreCase("prod")) {
    	WebWrapper.typeInField(AdobeLoginPage.getLoginPassword(), new Configuration().passwordProd());
    	}else
    	{
    		throw new RuntimeException("Wrong Environment");
    	}
    }
    
    public static void clickOnSignInButton() {
    	WebWrapper.clickOn(AdobeLoginPage.getSignInButton());
    }
	
    public static void clickOnSignOutButton() {
    	WebWrapper.clickOn(AdobeLoginPage.getSignOutButton());
    }
    
    public static void loginBase(String env) throws InterruptedException {
		AdobeHomePageAction.clickOnMyAccount();
		Report.passStep("Click On Adobe MyAccount");
		Thread.sleep(3000);
		insertLoginUsername(env);
		Report.passStep("Insert Email");
		insertLoginPassword(env);
		Report.passStep("Insert Password");
		clickOnSignInButton();
		Report.passStep("Click On SignIn");
	}
	
	public static void logOutBase() throws InterruptedException {
		AdobeHomePageAction.clickOnMyAccountLogged();
		Report.passStep("Click On MyAccount");
		clickOnSignOutButton();
		Report.passStep("Click On SignOut");
		
		
	}
	
	

}
