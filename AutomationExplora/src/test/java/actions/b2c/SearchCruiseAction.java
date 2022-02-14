package actions.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;
import pages.b2c.HomePage;
import pages.b2c.SearchCruisePage;
import wrappers.WebWrapper;

public class SearchCruiseAction extends setupDriver {
	
	
	public static void clickOnDestination() {
		WebWrapper.clickOn(SearchCruisePage.getDestinationSelect());
		
	}
	
	public static void clickOnSelectAndClose() {
		WebWrapper.clickOn(SearchCruisePage.getSelectAndCloseButton());
		
	}
	

	public static void clickSearchCruise() {
    	WebWrapper.clickOn(SearchCruisePage.getSearchCruiseButton());
    }
	
	
	public static void clickOnFirstBookButton() throws InterruptedException {
		WebWrapper.waitForJavascript(30000, 3000);
		Thread.sleep(2000);
	    WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("canvas", "14"));  
    }
	
	public static void clickOnCategorySuiteButton() throws InterruptedException {
		//WebWrapper.waitForJavascript(30000, 3000);
		Thread.sleep(2000);
	    WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("canvas", "9"));  
    }
	
	

}
