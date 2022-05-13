package actions.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import globalSetup.b2c.ExternalFunction;
import pages.b2c.AdobeBrochureRequestPage;
import pages.b2c.AdobeRequestAQuotePage;
import wrappers.WebWrapper;

public class AdobeRequestAQuoteAction {

	public static void setFirstName() throws InterruptedException {
		String firstname = "test"+ ExternalFunction.getRandomString(4);
		
		WebWrapper.typeInField(AdobeRequestAQuotePage.getFirstName(), firstname);
		}
	
	public static void setLastName() throws InterruptedException {
		String lastname = "test"+ ExternalFunction.getRandomString(4);
		
		WebWrapper.typeInField(AdobeRequestAQuotePage.getLastName(), lastname);
		}
	public static void setPhonePrefix() {
		String Prefix= ExternalFunction.getRandomInt(1, 10);
		int index=Integer.parseInt(Prefix);
    	Select code =new Select(AdobeRequestAQuotePage.getCountryCodeSelect());
    	code.selectByIndex(index);
    }
	
	public static void setPhone() {
		WebWrapper.typeInField(AdobeRequestAQuotePage.getMobileNumber(), ExternalFunction.getRandomNumber(10));
		}
	
	public static void setEmail() {
		String email = "automation"+ ExternalFunction.getRandomString(4)+"@yopmail.com";
		WebWrapper.typeInField(AdobeRequestAQuotePage.getEmail(), email);
		}
	
	public static void setQuoteSubject() {
		String Prefix= ExternalFunction.getRandomInt(1, 3);
		int index=Integer.parseInt(Prefix);
    	Select code =new Select(AdobeRequestAQuotePage.getQuoteSubject());
    	code.selectByIndex(index);
    }
	public static void clickOnContactMethod() {
		WebWrapper.clickOn(AdobeRequestAQuotePage.getContactMethod());
		}
	
	 
	public static void clickOnPrivacyMarketing() {
		WebWrapper.clickOn(AdobeRequestAQuotePage.getPrivacyMarketing());
		}
	public static void clickOnPrivacyProfiling() {
		WebWrapper.clickOn(AdobeRequestAQuotePage.getPrivacyProfiling());
		}
	public static void clickOnSubmitButton() {
		WebWrapper.clickOn(AdobeRequestAQuotePage.getSubmitButton());
		}
	public static void clickOnCloseButton() {
		WebWrapper.clickOn(AdobeRequestAQuotePage.getCloseButton());
		}
	
 
	
}
