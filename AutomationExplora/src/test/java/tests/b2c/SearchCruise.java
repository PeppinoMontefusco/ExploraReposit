package tests.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import actions.b2c.LoginAction;
import actions.b2c.SearchCruiseAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.WebWrapper;

public class SearchCruise extends setupDriver{
	
	@Test
	public static void createUser() throws InterruptedException {
		startPage.startPage();
		LoginAction.clickOnBookAJourney();
		SearchCruiseAction.clickOnDestination();
		SearchCruiseAction.clickOnSelectAndClose();
		SearchCruiseAction.clickSearchCruise();
		SearchCruiseAction.clickOnFirstBookButton();
		SearchCruiseAction.clickOnCategorySuiteButton();
		        
		
		
		
		

	}
	
	/*private static WebElement shadowDom;

	private static WebElement expandRootElement(WebElement element) {
	    WebElement ele = (WebElement) ((JavascriptExecutor) driver)
	        .executeScript("return arguments[0].shadowRoot",element);
	    return ele;
	}
	private static void findByShadowRoot(WebDriver driver) {
	    shadowDom = expandRootElement(
	        driver.findElement(By.tagName("flt-glass-pane")));
	}
	

	private static WebElement findByShadowButton() {
	    findByShadowRoot(driver);
	    return shadowDom.findElement(By.tagName("canvas"));
	}*/

}
