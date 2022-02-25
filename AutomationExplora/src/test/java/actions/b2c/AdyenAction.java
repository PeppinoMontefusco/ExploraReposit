package actions.b2c;

import pages.b2c.AdyenPage;
import pages.b2c.HomePage;
import wrappers.WebWrapper;

public class AdyenAction {
	
      public static void setCardNumber(String number) {
	        WebWrapper.typeInField(AdyenPage.getCardNumber(), number);
	}
      
      public static void setExpiryDate(String date) {
    		WebWrapper.typeInField(AdyenPage.getExpityDate(), date);
  		}
      
      public static void setCVV(String number) {
  		WebWrapper.typeInField(AdyenPage.getCVV(), number);
		}
      
      public static void clickOnPayButton() {
    		WebWrapper.clickOn(AdyenPage.getPayButton());
  		}
      

}
