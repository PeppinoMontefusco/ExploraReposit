package actions.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import globalSetup.b2c.setupDriver;
import pages.b2c.HomePage;
import pages.b2c.SearchCruisePage;
import wrappers.WebWrapper;

public class SearchCruiseAction extends setupDriver {
	
	public static void clickSearchCruise() {
    	WebWrapper.clickOn(SearchCruisePage.getSearchCruiseButton());
    }
	
	
	public static void clickOnFirstBookButton() throws InterruptedException {
		WebWrapper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Sort')]")));
		Thread.sleep(12000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		var WebElement = (WebElement) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('canvas')[11];");
		WebWrapper.clickOn(WebElement);  
    }

}
