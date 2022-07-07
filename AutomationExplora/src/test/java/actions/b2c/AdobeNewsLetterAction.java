package actions.b2c;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import pages.b2c.AdobeNewsLetterPage;
import pages.b2c.AdobeRegistrationPage;
import wrappers.WebWrapper;

public class AdobeNewsLetterAction extends setupDriver {
	
	public static String setEmail() {
		String email = "automation"+ ExternalFunction.getRandomString(4)+"@yopmail.com";
    	WebWrapper.typeInField(AdobeNewsLetterPage.getEmailField(), email);
		return email;
    	
    }
	
	public static void setPhonePrefix() {
		String Prefix= ExternalFunction.getRandomInt(1, 10);
		int index=Integer.parseInt(Prefix);
    	Select code =new Select(AdobeNewsLetterPage.getPhonePrefix());
    	code.selectByIndex(index);
    }
	
	public static void setPhone() {
		WebWrapper.typeInField(AdobeNewsLetterPage.getPhoneField(), ExternalFunction.getRandomNumber(10));
    }
	
	public static void setFirstName() {
		String fistname = "test"+ ExternalFunction.getRandomString(4);
    	WebWrapper.typeInField(AdobeNewsLetterPage.getFirstNameField(), fistname);
    }
	
	public static void setLastName() {
		String lastname = "test"+ ExternalFunction.getRandomString(4);
    	WebWrapper.typeInField(AdobeNewsLetterPage.getLastNameField(), lastname);
    }
	
	public static void setCustomerType() {
    	WebWrapper.clickOn(AdobeNewsLetterPage.getCustomerCheckBox());
    }
	
	public static void setPrivacyBox() {
    	WebWrapper.clickOn(AdobeNewsLetterPage.getPrivacyCheckBox());
    }

	
	public static void clickOnRegisterButton() {
    	WebWrapper.clickOn(AdobeNewsLetterPage.getRegisterButton());
    }
	
	public static void clickOnPopup() throws InterruptedException {
		
    	WebWrapper.clickOn(AdobeNewsLetterPage.getPopupButton());
    }
	
	
	
	
	
	
	
	
	
	

}
