package actions.b2c;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;
import wrappers.WebWrapper;

public class GuestAction extends setupDriver {
	
	public static void clickOnFirstName() throws InterruptedException {
		 
		WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("span", "11"));
		
	}
	
	public static void setFirstName() throws InterruptedException {
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('input')[0].contentEditable=true;");
		 
		WebWrapper.typeInField(WebWrapper.getElementInShadowRoot("input", "0"), "mario");
		
		
	}

}
