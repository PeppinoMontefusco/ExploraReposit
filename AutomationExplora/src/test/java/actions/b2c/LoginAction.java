package actions.b2c;

import globalSetup.b2c.Configuration;
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
    
    public static void insertLoginUsername() {
    	WebWrapper.typeInField(HomePage.getLoginUsername(), new Configuration().username());
    	
    }
    
    public static void insertLoginPassword() {
    	WebWrapper.typeInField(HomePage.getLoginUsername(), new Configuration().password());
    	
    }
    
	
	
	
	
	
	

}
