package actions.b2c;

import org.openqa.selenium.support.ui.Select;

import globalSetup.ExternalFunction;
import pages.b2c.AdobeBrochureRequestPage;
import pages.b2c.AdobeNewsLetterPage;
import pages.b2c.AdobeTalkWithUsPage;
import wrappers.WebWrapper;

public class AdobeBrochureRequestAction {
	
	public static void setFirstName() throws InterruptedException {
		String firstname = "test"+ ExternalFunction.getRandomString(4);
		WebWrapper.typeInField(AdobeBrochureRequestPage.getFirstName(), firstname);
		}
	
	public static void setLastName() {
		String lastname = "test"+ ExternalFunction.getRandomString(4);
		WebWrapper.typeInField(AdobeBrochureRequestPage.getLastName(), lastname);
		}
	
	public static void setEmail() {
		String email = "automation"+ ExternalFunction.getRandomString(4)+"@yopmail.com";
		WebWrapper.typeInField(AdobeBrochureRequestPage.getEmail(), email);
		}

	public static void setPhonePrefix() {
		String Prefix= ExternalFunction.getRandomInt(1, 10);
		int index=Integer.parseInt(Prefix);
    	Select code =new Select(AdobeBrochureRequestPage.getCountryCode());
    	code.selectByIndex(index);
    }
	
	public static void setPhone() {
		WebWrapper.typeInField(AdobeBrochureRequestPage.getPhone(), ExternalFunction.getRandomNumber(10));
		}
	
	public static void clickOnPrivacyCheckBox() {
		WebWrapper.clickOn(AdobeBrochureRequestPage.getProvacyCheckBox());
		}
	public static void clickOnSubmitButton() {
		WebWrapper.clickOn(AdobeBrochureRequestPage.getSubmitButton());
		}
	public static void clickOnCloseButton() {
		WebWrapper.clickOn(AdobeBrochureRequestPage.getClosetButton());
		}
	
	
}
