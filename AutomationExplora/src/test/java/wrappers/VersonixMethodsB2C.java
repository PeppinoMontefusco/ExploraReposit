package wrappers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import globalSetup.b2c.setupDriver;

public class VersonixMethodsB2C extends setupDriver {

	public static WebElement getElementInShadowRoot(String tag, String index) throws InterruptedException {
		//Thread.sleep(2000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		return	  (WebElement) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+index+"];");
		
	 }

	public static void clickOnTagNotClickable (String tag, String index  ) {
		 Actions actions = new Actions(driver);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement element=(WebElement) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+index+"];");
		   
			actions.moveToElement(element).click().build().perform();
		 
	 }

	public static void findSpanAndCompile(String nameOfField,String value) throws InterruptedException {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('span').length;");
		 boolean click =false;
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('span')["+i+"].innerText;");
			 if (text.startsWith(nameOfField)) {
				 String index =i+"";
				 WebWrapper.clickOn(getElementInShadowRoot("span", index));
				 WebWrapper.typeInField(getElementInShadowRoot("input", "0"), value);
				 click=true;
				 break;
				}
			
		 }
		 if(click==false) {
				 throw new RuntimeException("Impossible to compile the field");
				
			 
		 }
		 
		 
		 
	 }
	
	public static void searchInputAndCompile(String attribute, String value) throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('input').length;");
		 boolean click =false;
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('input')["+i+"].getAttribute('aria-label');");
			 if (text.contains(attribute)) {
				 String index =i+"";
				 //WebWrapper.clickOn(getElementInShadowRoot("input", index));
				 Thread.sleep(1000);
				 WebWrapper.typeInField(getElementInShadowRoot("input", index), value);
				 click=true;
				 break;
				 
			 }
			
			 }
		 if(click==false) {
			 throw new RuntimeException("Impossible to compile field");
			
		 
			     
	 }
	 }
	
	

	public static void findSpanAndClick(String nameOfField) throws InterruptedException {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('span').length;");
		 boolean click =false;
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('span')["+i+"].innerText;");
			 if (text.startsWith(nameOfField)) {
				 String index =i+"";
				 clickOnTagNotClickable("span", index);
				 click=true;
				 break;
			 }
			
			 }
		 if(click==false) {
			 throw new RuntimeException("Impossible to click");
			
		 
	 }
		 
		 
	 }

	public static void searchTagAndClick(String attribute, String tag) throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"').length;");
		 boolean click =false;
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+i+"].getAttribute('style');");
			 
			 if (text.contains(attribute)) {
				 String index =i+"";
				 WebWrapper.clickOn(getElementInShadowRoot(tag, index));
				 click=true;
				 break;
				 
			 }
			
			 }
		 if(click==false) {
			 throw new RuntimeException("Impossible to click");
			
		 
			     
	 }
	 }

	public static void searchTagNotClickableAndClick(String attribute, String tag) throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"').length;");
		 boolean click =false;
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+i+"].getAttribute('style');");
			 if (text.contains(attribute)) {
				 String index =i+"";
				 clickOnTagNotClickable(tag, index);
				 click=true;
				 break;
				 
			 }
			
			 }
		 if(click==false) {
			 throw new RuntimeException("Impossible to click");
			
		 
	 }
		 
	 }

	public static void clickOnCheckBox(String attribute, String tag) throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"').length;");
		 boolean click =false;
		 for(int i=0;i<indexAll;i++) {
			 indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"').length;");
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+i+"].getAttribute('width');");
			 if (text.contains(attribute)) {
				 String index =i+"";
				 clickOnTagNotClickable("svg", index);
				 click=true;
				 indexAll=0;
			 }
			 
			 }
		 if(click==false) {
			 throw new RuntimeException("Impossible to click");
			
		 
	 }
	}
	public static String storevalue(String tag , String value) throws InterruptedException {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"').length;");
		 boolean click =false;
		 String digit = null;
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+i+"].innerText;");
			 if (text.contains(value)) {
				 String index =i+"";
				 digit=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+index+"].innerText;");
				 click=true;
				 break;
			 }
			
			 }
		 if(click==false) {
			 throw new RuntimeException("Impossible to store");
			
		 
	 }
		return digit;
		 
		 
	 }
	
	public static void searchTagAndClickByOffset(String attribute, String tag, int x , int y) throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"').length;");
		 boolean click =false;
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+i+"].getAttribute('style');");
			 if (text.contains(attribute)) {
				 String index =i+"";
				 WebElement element = (WebElement) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('"+tag+"')["+index+"];");
				 new Actions(driver).moveToElement(element).moveByOffset(x,y).click().build().perform();
				 click=true;
				 break;
				 
			 }
			
			 }
		 if(click==false) {
			 throw new RuntimeException("Impossible to click");
			
		 
	 }
	
	}
	public static void searchTextFromSpan(String nameOfField) throws InterruptedException {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long indexAll =(long) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('span').length;");
		 boolean content =false;
		 for(int i=0;i<indexAll;i++) {
			 String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('span')["+i+"].innerText;");
			 if (text.equalsIgnoreCase(nameOfField)) {
				 String index =i+"";
				 content=true;
				 break;
			 }
			
			 }
		 if(content==false) {
			 throw new RuntimeException("Text search failed");
			
		 
	 }
		
		 
		 
	 }
	
	public static void startVersonixPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelector('flt-semantics-placeholder').click({force: true});");
		
	}
	
	public static void clickOnLabel(String label) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text=(String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelector('[aria-label="+label+"]').click();");
	}
	
	public static String getSummaryInformation(String label) throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelector('[aria-label^="+label+"]').innerText;");
		
		}
	public static void verifyValue(String base, String check, String control) {
		
		if (base.contains(check)) {
			Report.passStep("Value of "+control+" is ok");
		}
			else {
				throw new RuntimeException("Value of "+control+" is not ok");
				
			}
		}
	}

