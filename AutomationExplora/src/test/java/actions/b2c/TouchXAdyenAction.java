package actions.b2c;

import globalSetup.b2c.setupDriver;
import pages.b2c.TouchXAdyenPage;
import wrappers.WebWrapper;

public class TouchXAdyenAction extends setupDriver {
	
      public static void setCardNumber(String number) throws InterruptedException {
    	    Thread.sleep(2000);  
    	    driver.switchTo().frame(1);
  		    driver.switchTo().frame(0);
  		    Thread.sleep(2000);
	        WebWrapper.typeInField(TouchXAdyenPage.getCardNumber(), number);
	        
	}
      
      public static void setExpiryDate(String date) {
    	    driver.switchTo().defaultContent(); // Ritornare al document di default
  		    driver.switchTo().frame(1);
  		    driver.switchTo().frame(1);
    		WebWrapper.typeInField(TouchXAdyenPage.getExpityDate(), date);
  		}
      
      public static void setCVV(String number) {
    	driver.switchTo().defaultContent();
  		driver.switchTo().frame(1);
  		driver.switchTo().frame(2);
  		WebWrapper.typeInField(TouchXAdyenPage.getCVV(), number);
		}
      
      public static void clickOnPayButton() {
    	   driver.switchTo().defaultContent();
  		   driver.switchTo().frame(1);
  		   String Amount=TouchXAdyenAction.storeAmount().substring(5);
    		WebWrapper.clickOn(TouchXAdyenPage.getPayButton());
  		}
      
      public static String storeAmount() {
    	  return TouchXAdyenPage.getAmount().getText();
      }
      

}
