package actions.b2c;

import globalSetup.b2c.Configuration;
import pages.b2c.LoginPage;
import wrappers.WebWrapper;

public class LoginAction  {

	
	public static void insertLoginUsername() {
    	WebWrapper.typeInField(LoginPage.getLoginUsername(), new Configuration().username());
    	
    }
    
    public static void insertLoginPassword() {
    	WebWrapper.typeInField(LoginPage.getLoginPassword(), new Configuration().password());
    	
    }
    
    public static void clickOnSignInButton() {
    	WebWrapper.clickOn(LoginPage.getSignInButton());
    }
	
    public static void clickOnSignOutButton() {
    	WebWrapper.clickOn(LoginPage.getSignOutButton());
    }
    
    public static void loginBase() {
		HomePageAction.clickOnMyAccount();
		insertLoginUsername();
		insertLoginPassword();
		clickOnSignInButton();
	}
	
	public static void logOutBase() {
		HomePageAction.clickOnMyAccountLogged();
		clickOnSignOutButton();
		
	}
	

}
