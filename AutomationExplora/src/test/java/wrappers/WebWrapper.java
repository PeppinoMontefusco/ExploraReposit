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

import actions.b2c.GuestAction;
import actions.b2c.SearchCruiseAction;
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

	 
	 public static void clickOnAttributeNotClickable (String tag, String index  ) {
		 Actions actions = new Actions(driver);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement element=(WebElement) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+index+"];");
		   
			actions.moveToElement(element).click().build().perform();
		 
	 }
	 
	 public static void findSpanCompile(String nameOfField,String value) throws InterruptedException {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('span').length;");
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('span')["+i+"].innerText;");
			 if (text.startsWith(nameOfField)) {
				 String index =i+"";
				 GuestAction.clickOnFirstName(index);
				 GuestAction.setFirstName(value);
				 break;
			 }
		 }
		 
		 
	 }
 public static void findSpanClick(String nameOfField) throws InterruptedException {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('span').length;");
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('span')["+i+"].innerText;");
			 if (text.startsWith(nameOfField)) {
				 String index =i+"";
				 WebWrapper.clickOnAttributeNotClickable("span", index);
				 break;
			 }}
		 
		 
		 
	 }
	 
	 public static void flpClipSearchClick(String attribute, String tag) throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"').length;");
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+i+"].getAttribute('Style');");
			 if (text.contains(attribute)) {
				 String index =i+"";
				 SearchCruiseAction.clickOnSubCategorySuiteButton(index);
				 System.out.println(text);
				 break;
				 
			 }
			 }
	 }
	 
	 public static void flpClipSearchClickNotClickable(String attribute, String tag) throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"').length;");
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+i+"].getAttribute('Style');");
			 if (text.contains(attribute)) {
				 String index =i+"";
				 WebWrapper.clickOnAttributeNotClickable(tag, index);
				 System.out.println(text);
				 break;
				 
			 }
			 }
		 
	 }
	 
		 public static void clickOnCheckBox(String attribute, String tag) throws InterruptedException {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"').length;");
			 for(int i=0;i<indexAll;i++) {
				 indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"').length;");
				 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+i+"].getAttribute('width');");
				 if (text.contains(attribute)) {
					 String index =i+"";
					 WebWrapper.clickOnAttributeNotClickable("svg", index);
					 
					 indexAll=0;
				 }
				 }
		 }
		 
		 
	 }
	 
	 
	 

		


   




