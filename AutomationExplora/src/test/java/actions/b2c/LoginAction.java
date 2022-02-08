package actions.b2c;

import org.openqa.selenium.support.ui.Select;

import globalSetup.b2c.Configuration;
import globalSetup.b2c.ExternalFunction;
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
    	WebWrapper.typeInField(HomePage.getLoginPassword(), new Configuration().password());
    	
    }
    
    public static void clickOnSignInButton() {
    	WebWrapper.clickOn(HomePage.getSignInButton());
    }
	
    public static void clickOnSignOutButton() {
    	WebWrapper.clickOn(HomePage.getSignOutButton());
    }
    
    public static void clickOnCreateAccountButton() {
    	WebWrapper.clickOn(HomePage.getCreateAccountButton());
    }
    
    public static void insertCreateAccountEmail() {
    	String email = "Automation"+ ExternalFunction.getRandomString(4)+"@yopmail.com";
    	WebWrapper.typeInField(HomePage.getCreateAccountEmail(), email );
    	
    }
    
    public static void insertCreateAccountPassword() {
    	WebWrapper.typeInField(HomePage.getCreateAccountPassword(), new Configuration().password());
    	
    }
    
    public static void insertCreateAccountConfirmPassword() {
    	WebWrapper.typeInField(HomePage.getCreateAccountConfirmPassword(), new Configuration().password());
    	
    }
    
    public static void insertCreateAccountFirstName() {
    	String firstname = "Testname"+ ExternalFunction.getRandomString(4);
    	WebWrapper.typeInField(HomePage.getCreateAccountFirstName(), firstname);
    	
    }
    
    public static void insertCreateAccountLastName() {
    	String lastname = "Testsurname"+ ExternalFunction.getRandomString(4);
    	WebWrapper.typeInField(HomePage.getCreateAccountLastName(), lastname);
    	
    }
    public static void insertCreateAccountDOBYear() {
    	Select year =new Select(HomePage.getCreateAccountDOBYear());
    	year.selectByVisibleText("1960");
    }
    
    public static void setCreateAccountPrivacy1() {
    	WebWrapper.clickOn(HomePage.getCreateAccountPrivacy1());
    }
    
    public static void setCreateAccountPrivacy2() {
    	WebWrapper.clickOn(HomePage.getCreateAccountPrivacy2());
    }
    
    public static void clickCreateAccountSubmitButton() {
    	WebWrapper.clickOn(HomePage.getCreateAccountSubmitButton());
    }
    
    
    
    
	public static void loginBase() {
		clickOnMyAccount();
		insertLoginUsername();
		insertLoginPassword();
		clickOnSignInButton();
	}
	
	public static void logOutBase() {
		clickOnMyAccountLogged();
		clickOnSignOutButton();
		
	}
	

}
