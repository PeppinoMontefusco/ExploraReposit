package actions.b2c;

import pages.b2c.AdyenPage;
import pages.b2c.HomePage;
import wrappers.WebWrapper;

public class AdyenAction {
	
public static void setCardNumber(String number) {
		
		WebWrapper.typeInField(AdyenPage.getCardNumber(), number);
		
	}

}
