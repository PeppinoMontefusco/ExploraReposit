package actions.b2c;

import globalSetup.b2c.setupDriver;
import wrappers.WebWrapper;

public class GuestAction extends setupDriver {
	
	public static void clickOnFirstName() throws InterruptedException {
		 
		WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("span", "11"));
		
	}
	
	public static void setFirstName() throws InterruptedException {
		 
		WebWrapper.typeInField(WebWrapper.getElementInShadowRoot("input", "0"), "mario");
		
		
	}

}
