package actions.b2c;

import globalSetup.b2c.Configuration;
import pages.b2c.AdobeLoginPage;
import pages.b2c.TouchXLoginPage;
import wrappers.WebWrapper;

public class TouchXLoginAction {
	
	public static void setUsername() {
    	WebWrapper.typeInField(TouchXLoginPage.getUsername(), new Configuration().username());
    	
    }
	
	public static void setPassword() {
    	WebWrapper.typeInField(TouchXLoginPage.getPassword(), new Configuration().password());
    	
    }
	
	public static void clickOnSignIn() {
    	WebWrapper.clickOn(TouchXLoginPage.getSignInButton());
    	
    	
    }
	
	

}
