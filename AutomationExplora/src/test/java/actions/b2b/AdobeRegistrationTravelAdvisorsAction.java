package actions.b2b;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import pages.b2b.AdobeLoginTravelAdvisorsPage;
import pages.b2b.AdobeRegistrationTravelAdvisorsPage;
import pages.b2c.AdobeNewsLetterPage;
import wrappers.WebWrapper;

public class AdobeRegistrationTravelAdvisorsAction extends setupDriver {

	static String email;
	
	public static void selectTitle() {
	
    	Select code =new Select(AdobeRegistrationTravelAdvisorsPage.getSelectTitle());
    	int n = code.getOptions().size();
    	String random= ExternalFunction.getRandomInt(1, n-1);
		int index=Integer.parseInt(random);
    	code.selectByIndex(index);
	}
	
	public static void setFirstName() {
		String firstname = "TESTname"+ ExternalFunction.getRandomString(4);
		WebWrapper.typeInField(AdobeRegistrationTravelAdvisorsPage.getRegFirstName(), firstname);
	}
	
	public static void setLastName() {
		String lastname = "TESTSurname"+ ExternalFunction.getRandomString(4);
		WebWrapper.typeInField(AdobeRegistrationTravelAdvisorsPage.getRegLastName(), lastname);
	}
	
	public static void selectCountryOfResidence() {
		
    	Select code =new Select(AdobeRegistrationTravelAdvisorsPage.getCountryOfResidenceSelect());
    	int n = code.getOptions().size();
    	String random= ExternalFunction.getRandomInt(1, n-1);
		int index=Integer.parseInt(random);
    	code.selectByIndex(index);
	}
	
    public static void selectCountryCode() {
		
    	Select code =new Select(AdobeRegistrationTravelAdvisorsPage.getCountryCodeSelect());
    	int n = code.getOptions().size();
    	String random= ExternalFunction.getRandomInt(1, n-1);
		int index=Integer.parseInt(random);
    	code.selectByIndex(index);
	}
    public static void setPhone() {
    	String n=ExternalFunction.getRandomNumber(10);
    	WebWrapper.typeInField(AdobeRegistrationTravelAdvisorsPage.getPhoneNumber(), n);
    }
    public static void setAgencyName() {
    	String name = "TESTAgency"+ ExternalFunction.getRandomString(4);
    	WebWrapper.typeInField(AdobeRegistrationTravelAdvisorsPage.getTravelAgencyName(), name);
    }
    
    public static void setAgencyOnLine() {
    	
    	WebWrapper.clickOn(AdobeRegistrationTravelAdvisorsPage.getRadioAgencyOnline());
    }
    
   public static void setAgencyAddress() {
    	
	   WebWrapper.typeInField(AdobeRegistrationTravelAdvisorsPage.getAgencyAddress(), "Via Test");
    }
   
   public static void setZipCode() {
   	   String n =ExternalFunction.getRandomNumber(5);
	   WebWrapper.typeInField(AdobeRegistrationTravelAdvisorsPage.getZipCode(), n);
    }
   public static void setAgencyCity() {
	   	
	   WebWrapper.typeInField(AdobeRegistrationTravelAdvisorsPage.getAgencyCity(), "Test");
    }
   
   public static void setAgencyAddress1() {
	   	
	   WebWrapper.typeInField(AdobeRegistrationTravelAdvisorsPage.getAgencyAddress1(), "Via Test");
    }
   
   public static String setAgencyEmail() {
	   email = "automation"+ ExternalFunction.getRandomString(4)+"@yopmail.com";
	   WebWrapper.typeInField(AdobeRegistrationTravelAdvisorsPage.getEmail(), email);
	return email;
    }
   
   public static void setAgencyConfirmEmail() {
	   
	   WebWrapper.typeInField(AdobeRegistrationTravelAdvisorsPage.getConfirmEmail(), email);
    }
   
   public static void clickOnMarketingFlag() {
	   
	   WebWrapper.clickOn(AdobeRegistrationTravelAdvisorsPage.getMarketingConsent());
    }
   public static void clickOnProfilingFlag() {
	   
	   WebWrapper.clickOn(AdobeRegistrationTravelAdvisorsPage.getProfilingConsent());
    }
   
 public static void clickOnSubmitButton() {
	   
	   WebWrapper.clickOn(AdobeRegistrationTravelAdvisorsPage.getSubmitButton());
    }
   
 public static void clickOnPopupBackButton() throws InterruptedException {
	 JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("return window.scrollTo(0,0)");
 	WebWrapper.clickOn(AdobeRegistrationTravelAdvisorsPage.getPopupBackButton());
 }
	
   
   
    
}
