package wrappers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import globalSetup.b2c.setupDriver;

public class WebWrapper extends setupDriver {
	
	private static  WebDriverWait webDriverWait;
	private final JavascriptExecutor javascriptExecutor;
	
	
	
	 
		public WebWrapper() {
	    	//WebWrapper.webDriverWait = new WebDriverWait(driver, 60);
	    	this.javascriptExecutor = (JavascriptExecutor) driver;
	    	
	    }

    
    public static void clickOn(WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, 60);    
    	    wait.until(ExpectedConditions.elementToBeClickable(element));
    	    if (element.isDisplayed()){
    	    	wait.until(ExpectedConditions.visibilityOf(element));
    	    }
    	    else {
    	    	scrollToElement(element);
    	    	wait.until(ExpectedConditions.visibilityOf(element));
    	    	
    	    }
	         double startTime = System.currentTimeMillis();
	        RuntimeException exception = null;
	        while (System.currentTimeMillis() < startTime + 20000) {
	            try {
	                element.click();
	                return;
	            } catch (RuntimeException e) {
	                exception = e;
	                waitInMilliseconds(500);
	            }
	        }
	        if (exception != null)
	            throw exception;
	    }

	private static void waitInMilliseconds(int i) {
		 try {
	            Thread.sleep(i);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
		
	


	private static void scrollToElement(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		
	}
	
	 public static void typeInField(WebElement element, String value) {
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 wait.until(ExpectedConditions.visibilityOf(element));
		 //scrollToElement(element);
	     element.sendKeys(value);
	    }

}
