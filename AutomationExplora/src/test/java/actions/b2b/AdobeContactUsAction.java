package actions.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import globalSetup.Configuration;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import pages.b2b.AdobeContactUsPage;
import pages.b2b.AdobeLoginTravelAdvisorsPage;
import pages.b2b.AdobeRegistrationTravelAdvisorsPage;
import wrappers.WebWrapper;

public class AdobeContactUsAction extends setupDriver {

	public static void setFirstName() {
		String firstname = "TESTname"+ ExternalFunction.getRandomString(4);
		WebWrapper.typeInField(AdobeContactUsPage.getFirstName(), firstname);
	}
	
	public static void setLastName() {
		String lastname = "TESTSurname"+ ExternalFunction.getRandomString(4);
		WebWrapper.typeInField(AdobeContactUsPage.getLastName(), lastname);
	}
	 public static String setEmail() {
		   String email = "automation"+ ExternalFunction.getRandomString(4)+"@yopmail.com";
		   WebWrapper.typeInField(AdobeContactUsPage.getEmail(), email);
		return email;
	    }
	 public static void selectCountryCode() {
			
	    	Select code =new Select(AdobeContactUsPage.getCountryCode());
	    	int n = code.getOptions().size();
	    	String random= ExternalFunction.getRandomInt(1, n-1);
			int index=Integer.parseInt(random);
	    	code.selectByIndex(index);
		}
	  public static void setPhone() {
	    	String n=ExternalFunction.getRandomNumber(10);
	    	WebWrapper.typeInField(AdobeContactUsPage.getPhone(), n);
	    }
	  public static void setTopic() {
	    	
	    	WebWrapper.clickOn(AdobeContactUsPage.getTopic());
	    }
	  public static void setMessage() {
	    	WebWrapper.typeInField(AdobeContactUsPage.getMessageBox(), "Test Automation");
	    }
	  
	  public static void clickOnSend() {
	    	
	    	WebWrapper.clickOn(AdobeContactUsPage.getSendButton());
	    }
	  public static void clickOnBack() {
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
		    executor.executeScript("return window.scrollTo(0,0)");
		  WebWrapper.clickOn(AdobeContactUsPage.getBackButton());
		 
	    }
	  
	  
}
