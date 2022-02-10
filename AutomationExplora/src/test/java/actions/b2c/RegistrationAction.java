package actions.b2c;

import org.openqa.selenium.support.ui.Select;

import globalSetup.b2c.Configuration;
import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;
import pages.b2c.RegistrationPage;
import wrappers.WebWrapper;

public class RegistrationAction extends setupDriver{

	  public static void clickOnCreateAccountButton() {
	    	WebWrapper.clickOn(RegistrationPage.getCreateAccountButton());
	    }
	    
	    public static String insertCreateAccountEmail() throws InterruptedException {
			Thread.sleep(3000);
            String email = "automation"+ ExternalFunction.getRandomString(4)+"@folllo.com";
            
	    	WebWrapper.typeInField(RegistrationPage.getCreateAccountEmail(), email );
	    	return email;
	    	
	    }
	    
	    public static void insertCreateAccountPassword() {
	    	WebWrapper.typeInField(RegistrationPage.getCreateAccountPassword(), new Configuration().password());
	    	
	    }
	    
	    public static void insertCreateAccountConfirmPassword() {
	    	WebWrapper.typeInField(RegistrationPage.getCreateAccountConfirmPassword(), new Configuration().password());
	    	
	    }
	    
	    public static void insertCreateAccountFirstName() {
	    	String firstname = "TESTname"+ ExternalFunction.getRandomString(4);
	    	WebWrapper.typeInField(RegistrationPage.getCreateAccountFirstName(), firstname);
	    	
	    }
	    
	    public static void insertCreateAccountLastName() {
	    	String lastname = "TESTsurname"+ ExternalFunction.getRandomString(4);
	    	WebWrapper.typeInField(RegistrationPage.getCreateAccountLastName(), lastname);
	    	
	    }
	    
	    public static void insertCreateAccountDOBDay() {
	    	String DOBDay= ExternalFunction.getRandomInt(1, 28);
	    	Select day =new Select(RegistrationPage.getCreateAccountDOBDay());
	    	day.selectByVisibleText(DOBDay);
	    }
	    
	    public static void insertCreateAccountDOBMonth() {
	    	int DOBMonth= Integer.valueOf(ExternalFunction.getRandomInt(0, 11));
	    	
	    	Select month =new Select(RegistrationPage.getCreateAccountDOBMonth());
	    	month.selectByIndex(DOBMonth);
	    }
	    
	    public static void insertCreateAccountDOBYear() {
	    	String DOBYear= ExternalFunction.getRandomInt(1940, 2000);
	    	Select year =new Select(RegistrationPage.getCreateAccountDOBYear());
	    	year.selectByVisibleText(DOBYear);
	    }
	    
	    public static void setCreateAccountPrivacy1() {
	    	WebWrapper.clickOn(RegistrationPage.getCreateAccountPrivacy1());
	    }
	    
	    public static void setCreateAccountPrivacy2() {
	    	WebWrapper.clickOn(RegistrationPage.getCreateAccountPrivacy2());
	    }
	    
	    public static void clickCreateAccountSubmitButton() {
	    	WebWrapper.clickOn(RegistrationPage.getCreateAccountSubmitButton());
	    }
	    public static void clickCreateAccountCloseButton() {
	    	WebWrapper.clickOn(RegistrationPage.getCreateAccountClosePopup());
	    }
	    public static void clickCreateAccountSuccessClose() {
	    	WebWrapper.clickOn(RegistrationPage.getCreateAccountSuccessClose());
	    }
	    
	
}
