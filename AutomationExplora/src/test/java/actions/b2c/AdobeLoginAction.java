package actions.b2c;

import globalSetup.b2c.Configuration;
import pages.b2c.AdobeLoginPage;
import wrappers.Report;
import wrappers.WebWrapper;

public class AdobeLoginAction  {

	
	public static void insertLoginUsername() {
    	WebWrapper.typeInField(AdobeLoginPage.getLoginUsername(), new Configuration().username());
    	
    }
    
    public static void insertLoginPassword() {
    	WebWrapper.typeInField(AdobeLoginPage.getLoginPassword(), new Configuration().password());
    	
    }
    
    public static void clickOnSignInButton() {
    	WebWrapper.clickOn(AdobeLoginPage.getSignInButton());
    }
	
    public static void clickOnSignOutButton() {
    	WebWrapper.clickOn(AdobeLoginPage.getSignOutButton());
    }
    
    public static void loginBase() throws InterruptedException {
		AdobeHomePageAction.clickOnMyAccount();
		Report.passStep("Click On Adobe MyAccount");
		Thread.sleep(3000);
		insertLoginUsername();
		Report.passStep("Insert Email");
		insertLoginPassword();
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
