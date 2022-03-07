package actions.b2c;

import globalSetup.b2c.setupDriver;
import pages.b2c.AdyenPage;
import wrappers.WebWrapper;

public class AdyenAction extends setupDriver {
	
      public static void setCardNumber(String number) throws InterruptedException {
    	    Thread.sleep(2000);  
    	    driver.switchTo().frame(1);
  		    driver.switchTo().frame(0);
  		    Thread.sleep(2000);
	        WebWrapper.typeInField(AdyenPage.getCardNumber(), number);
	        
	}
      
      public static void setExpiryDate(String date) {
    	    driver.switchTo().defaultContent(); // Ritornare al document di default
  		    driver.switchTo().frame(1);
  		    driver.switchTo().frame(1);
    		WebWrapper.typeInField(AdyenPage.getExpityDate(), date);
  		}
      
      public static void setCVV(String number) {
    	driver.switchTo().defaultContent();
  		driver.switchTo().frame(1);
  		driver.switchTo().frame(2);
  		WebWrapper.typeInField(AdyenPage.getCVV(), number);
		}
      
      public static void clickOnPayButton() {
    	   driver.switchTo().defaultContent();
  		   driver.switchTo().frame(1);
  		   String Amount=AdyenAction.storeAmount().substring(5);
    		WebWrapper.clickOn(AdyenPage.getPayButton());
  		}
      
      public static String storeAmount() {
    	  return AdyenPage.getAmount().getText();
      }
      

}
