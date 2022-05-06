package actions.b2c;

import globalSetup.b2c.setupDriver;
import pages.b2c.TouchXAdyenPage;
import wrappers.WebWrapper;

public class TouchXAdyenAction extends setupDriver {
	
      public static void setCardNumber(String number) throws InterruptedException {
    	    Thread.sleep(2000);  
    	    driver.switchTo().frame(2);
  		    driver.switchTo().frame(0);
  		    Thread.sleep(2000);
	        WebWrapper.typeInField(TouchXAdyenPage.getCardNumber(), number);
	        
	}
      
      public static void setExpiryDate(String date) {
    	    driver.switchTo().defaultContent(); // Ritornare al document di default
  		    driver.switchTo().frame(2);
  		    driver.switchTo().frame(1);
    		WebWrapper.typeInField(TouchXAdyenPage.getExpityDate(), date);
  		}
      
      public static void setCVV(String number) {
    	driver.switchTo().defaultContent();
  		driver.switchTo().frame(2);
  		driver.switchTo().frame(2);
  		WebWrapper.typeInField(TouchXAdyenPage.getCVV(), number);
		}
      
      public static void clickOnPayButton() {
    	   driver.switchTo().defaultContent();
  		   driver.switchTo().frame(2);
  		   
    		WebWrapper.clickOn(TouchXAdyenPage.getPayButton());
    		driver.switchTo().defaultContent();
  		}
      
      public static String storeAmount() {
    	  return TouchXAdyenPage.getAmount().getText();
      }
      
      public static void setUsername3DS1(String username) {
   	      driver.switchTo().frame(1);
   	      
   	     WebWrapper.typeInField(TouchXAdyenPage.getUsername3DS1(), username);
      }
   	  public static void setPassword3DS1(String password) {
   	      WebWrapper.typeInField(TouchXAdyenPage.getPassword3DS1(), password);
   	  }
   	  public static void clickOnSubmitButton3DS1(){
   		WebWrapper.clickOn(TouchXAdyenPage.getPayButton3DS1());
   		driver.switchTo().defaultContent();
   	  }
   	public static void setPassword3DS2(String password) {
   		  driver.switchTo().frame(1);
 	      driver.switchTo().frame(0);
 	      WebWrapper.waitForJavascript();
 	      WebWrapper.typeInField(TouchXAdyenPage.getPassword3DS2(), password);
 	  }
   	public static void clickOnSubmitButton3DS2() {
   		WebWrapper.clickOn(TouchXAdyenPage.getSubmitButton3DS2());
 	  }

}
