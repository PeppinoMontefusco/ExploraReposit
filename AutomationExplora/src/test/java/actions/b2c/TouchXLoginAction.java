package actions.b2c;

import globalSetup.b2c.Configuration;
import globalSetup.b2c.setupDriver;
import pages.b2c.TouchXLoginPage;
import wrappers.WebWrapper;

public class TouchXLoginAction extends setupDriver {
	
	public static void setUsername() {
		driver.switchTo().frame(2);
		WebWrapper.typeInField(TouchXLoginPage.getUsername(), new Configuration().username());
    	
    }
	
	public static void setPassword() {
    	WebWrapper.typeInField(TouchXLoginPage.getPassword(), new Configuration().password());
    	
    }
	
	public static void clickOnSignIn() {
    	WebWrapper.clickOn(TouchXLoginPage.getSignInButton());
    	driver.switchTo().defaultContent();
    	
    	
    }
	
	

}
