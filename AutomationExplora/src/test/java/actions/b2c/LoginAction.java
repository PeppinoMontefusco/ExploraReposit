package actions.b2c;

import globalSetup.b2c.setupDriver;
import pages.b2c.HomePage;
import wrappers.WebWrapper;

public class LoginAction extends setupDriver {

	
	public static void clickOnMyAccount() {
		
		WebWrapper.clickOn(HomePage.getMyAccountButton());
		
	}
	
    public static void clickOnMyAccountLogged() {
    	
    	WebWrapper.clickOn(HomePage.getMyAccountLoggedButton());
		
	}
	
	
	
	
	
	

}
