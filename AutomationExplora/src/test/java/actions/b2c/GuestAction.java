package actions.b2c;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;
import wrappers.WebWrapper;

public class GuestAction extends setupDriver {
	
	public static void clickOnFirstName(String indice) throws InterruptedException {
		 
		WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("span", indice));
		
	}
	
	public static void setFirstName(String value) throws InterruptedException {
		
		 WebWrapper.typeInField(WebWrapper.getElementInShadowRoot("input", "0"), value);
	
	}
	
	public static void clickOnLastName(String indice) throws InterruptedException {
		 
		WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("span", indice));
		
	}
	
	
	
	
	public static void setLastName() throws InterruptedException {
		
		 WebWrapper.typeInField(WebWrapper.getElementInShadowRoot("input", "0"), "paolo");
	
	}
	
	public static void clickOnGender(String indice) throws InterruptedException {
		 
		WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("span", indice));
		
	}
	public static void clickOnDateOfBirth(String indice) throws InterruptedException {
		 
		WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("span", indice));
		
	}
	
	public static void setDOB() throws InterruptedException {
		
		 WebWrapper.typeInField(WebWrapper.getElementInShadowRoot("input", "0"), "01011990");
	
	}
	
	public static void clickOnEmail(String indice) throws InterruptedException {
		 
		WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("span", indice));
		
	}
	
	public static void setEmail() throws InterruptedException {
		
		 WebWrapper.typeInField(WebWrapper.getElementInShadowRoot("input", "0"), "test@yopmail.com");
	
	}
	
	public static void clickOnContinue(String indice) throws InterruptedException {
		 
		WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("flt-clip", indice));
		
	}
	
	
	
	
	
	


}
