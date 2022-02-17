package wrappers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import globalSetup.b2c.setupDriver;

public class WebWrapper extends setupDriver {
	
	public static  WebDriverWait wait;
	private final static JavascriptExecutor javascriptExecutor;
	
	
	
	 
		static {
	    	WebWrapper.wait = new WebDriverWait(driver, 60);
	    	javascriptExecutor = (JavascriptExecutor) driver;
	    	
	    }

    
    public static void clickOn(WebElement element) {
	           
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
        javascriptExecutor.executeScript(scrollElementIntoMiddle, element);
		
	}
	
	 public static void typeInField(WebElement element, String value) {
		 
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 wait.until(ExpectedConditions.visibilityOf(element));
		 //scrollToElement(element);
	     element.sendKeys(value);
	    }

	 public static void waitForJavascript(int maxWaitMillis, int pollDelimiter) {
		    double startTime = System.currentTimeMillis();
		    while (System.currentTimeMillis() < startTime + maxWaitMillis) {
		        String prevState = driver.getPageSource();
		        try {
					Thread.sleep(pollDelimiter);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // <-- would need to wrap in a try catch
		        if (prevState.equals(driver.getPageSource())) {
		            return;
		        }
		    }
		}
	 public static WebElement getElementInShadowRoot(String tag, String index) throws InterruptedException {
		Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
		return	  (WebElement) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+index+"];");
		
	 } 
	 

	 public static void clickOnElementNotClickable(WebElement element) throws InterruptedException{
		 
		 Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
	 }

	 public static void zoomOut() throws AWTException, InterruptedException {
		 Robot robot = new Robot();
			for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
		
          }
	 }
}
		


   




