package actions.b2c;

import org.openqa.selenium.support.ui.Select;

import globalSetup.Configuration;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import pages.b2c.AdobeRegistrationPage;
import wrappers.WebWrapper;

public class AdobeRegistrationAction extends setupDriver{

	  public static void clickOnCreateAccountButton() {
	    	WebWrapper.clickOn(AdobeRegistrationPage.getCreateAccountButton());
	    }
	    
	    public static String insertCreateAccountEmail() throws InterruptedException {
			Thread.sleep(3000);
            String email = "automation"+ ExternalFunction.getRandomString(4)+"@folllo.com";
            
	    	WebWrapper.typeInField(AdobeRegistrationPage.getCreateAccountEmail(), email );
	    	return email;
	    	
	    }
	    
	    public static void insertCreateAccountPassword() {
	    	WebWrapper.typeInField(AdobeRegistrationPage.getCreateAccountPassword(), new Configuration().password());
	    	
	    }
	    
	    public static void insertCreateAccountConfirmPassword() {
	    	WebWrapper.typeInField(AdobeRegistrationPage.getCreateAccountConfirmPassword(), new Configuration().password());
	    	
	    }
	    
	    public static void insertCreateAccountFirstName() {
	    	String firstname = "TESTname"+ ExternalFunction.getRandomString(4);
	    	WebWrapper.typeInField(AdobeRegistrationPage.getCreateAccountFirstName(), firstname);
	    	
	    }
	    
	    public static void insertCreateAccountLastName() {
	    	String lastname = "TESTsurname"+ ExternalFunction.getRandomString(4);
	    	WebWrapper.typeInField(AdobeRegistrationPage.getCreateAccountLastName(), lastname);
	    	
	    }
	    
	    public static void insertCreateAccountDOBDay() {
	    	String DOBDay= ExternalFunction.getRandomInt(1, 28);
	    	Select day =new Select(AdobeRegistrationPage.getCreateAccountDOBDay());
	    	day.selectByVisibleText(DOBDay);
	    }
	    
	    public static void insertCreateAccountDOBMonth() {
	    	int DOBMonth= Integer.valueOf(ExternalFunction.getRandomInt(0, 11));
	    	
	    	Select month =new Select(AdobeRegistrationPage.getCreateAccountDOBMonth());
	    	month.selectByIndex(DOBMonth);
	    }
	    
	    public static void insertCreateAccountDOBYear() {
	    	String DOBYear= ExternalFunction.getRandomInt(1940, 2000);
	    	Select year =new Select(AdobeRegistrationPage.getCreateAccountDOBYear());
	    	year.selectByVisibleText(DOBYear);
	    }
	    
	    public static void setCreateAccountPrivacy1() {
	    	WebWrapper.clickOn(AdobeRegistrationPage.getCreateAccountPrivacy1());
	    }
	    
	    public static void setCreateAccountPrivacy2() {
	    	WebWrapper.clickOn(AdobeRegistrationPage.getCreateAccountPrivacy2());
	    }
	    
	    public static void clickCreateAccountSubmitButton() {
	    	WebWrapper.clickOn(AdobeRegistrationPage.getCreateAccountSubmitButton());
	    }
	    public static void clickCreateAccountCloseButton() {
	    	WebWrapper.clickOn(AdobeRegistrationPage.getCreateAccountClosePopup());
	    }
	    public static void clickCreateAccountSuccessClose() {
	    	WebWrapper.clickOn(AdobeRegistrationPage.getCreateAccountSuccessClose());
	    }
	    
	
}
