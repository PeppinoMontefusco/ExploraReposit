package actions.b2c;

import globalSetup.Configuration;
import globalSetup.setupDriver;
import pages.b2c.TouchXLoginPage;
import wrappers.Report;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

public class TouchXLoginAction extends setupDriver {
	
	public static void setUsername() {
		driver.switchTo().frame(1);
		WebWrapper.typeInField(TouchXLoginPage.getUsername(), new Configuration().username());
    	
    }
	
	public static void setPassword() {
    	WebWrapper.typeInField(TouchXLoginPage.getPassword(), new Configuration().password());
    	
    }
	
	public static void clickOnSignIn() {
    	WebWrapper.clickOn(TouchXLoginPage.getSignInButton());
    	driver.switchTo().defaultContent();
    	
    	
    }
	
	public static void loginBaseTouchX() throws InterruptedException {
		VersonixMethodsB2C.searchTagNotClickableAndClick("height: 28px","flt-clip");
		Report.passStep("Click On Sign In ");
		WebWrapper.waitForJavascript();
		TouchXLoginAction.setUsername();
		Report.passStep("Insert Username");
		TouchXLoginAction.setPassword();
		Report.passStep("Insert Password");
		TouchXLoginAction.clickOnSignIn();
		Report.passStep("Click On Sign In Button");
		WebWrapper.waitForJavascript();
		Thread.sleep(3000);
	}
	
	

}
