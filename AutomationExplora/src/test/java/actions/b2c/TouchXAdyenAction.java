package actions.b2c;

import globalSetup.b2c.Configuration;
import globalSetup.b2c.setupDriver;
import pages.b2c.TouchXAdyenPage;
import wrappers.Report;
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
   	      driver.switchTo().frame(2);
   	      
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
   		  driver.switchTo().frame(2);
 	      driver.switchTo().frame(0);
 	      WebWrapper.waitForJavascript();
 	      WebWrapper.typeInField(TouchXAdyenPage.getPassword3DS2(), password);
 	  }
   	public static void clickOnSubmitButton3DS2() {
   		WebWrapper.clickOn(TouchXAdyenPage.getSubmitButton3DS2());
 	  }

   	public static void paymentNormalCard() throws InterruptedException {
   		setCardNumber(new Configuration().cardNumber());
		Report.passStep("Insert Card Number");
		setExpiryDate(new Configuration().expireDate());
		Report.passStep("Insert Expiry Date");
		setCVV(new Configuration().cvv());
		Report.passStep("Insert Cvv");
		clickOnPayButton();
		Report.passStep("Click On Pay");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
   	}
   	
   	public static void payment3ds1Card() throws InterruptedException {
   		setCardNumber(new Configuration().cardNumber3DS1());
		Report.passStep("Insert Card Number");
		setExpiryDate(new Configuration().expireDate());
		Report.passStep("Insert Expiry Date");
		setCVV(new Configuration().cvv());
		Report.passStep("Insert Cvv");
		clickOnPayButton();
		Report.passStep("Click On Pay");
		WebWrapper.waitForJavascript();
		setUsername3DS1(new Configuration().username3DS1());
		Report.passStep("Insert Username");
		setPassword3DS1(new Configuration().password3DS1());
		Report.passStep("Insert Password");
		clickOnSubmitButton3DS1();
		Report.passStep("Click On Submit");
   	}
   	
   	public static void payment3ds2Card() throws InterruptedException {
   		setCardNumber(new Configuration().cardNumber3DS2());
		Report.passStep("Insert Card Number");
		setExpiryDate(new Configuration().expireDate());
		Report.passStep("Insert Expiry Date");
		setCVV(new Configuration().cvv());
		Report.passStep("Insert Cvv");
		clickOnPayButton();
		Report.passStep("Click On Pay");
		WebWrapper.waitForJavascript();
 	    setPassword3DS2(new Configuration().password3DS1());
		Report.passStep("Insert Password");
		clickOnSubmitButton3DS2();
		Report.passStep("Click On Submit");
   	}
}
