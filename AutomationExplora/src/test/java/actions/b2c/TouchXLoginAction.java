package actions.b2c;

import globalSetup.Configuration;
import globalSetup.setupDriver;
import pages.b2c.TouchXLoginPage;
import wrappers.Report;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

public class TouchXLoginAction extends setupDriver {
	
	public static void setUsername(String env) {
		if (env.equalsIgnoreCase("test")) {
			driver.switchTo().frame(1);
		WebWrapper.typeInField(TouchXLoginPage.getUsername(), new Configuration().username());
		}else if (env.equalsIgnoreCase("prod")) {
			driver.switchTo().frame(2);
			WebWrapper.typeInField(TouchXLoginPage.getUsername(), new Configuration().usernameProd());	
		}
		else {
			throw new RuntimeException("Impossible to compile the field");
		}
    }
	
	public static void setPassword(String env) {
		if (env.equalsIgnoreCase("test")) {
			WebWrapper.typeInField(TouchXLoginPage.getPassword(), new Configuration().password());
			}else if (env.equalsIgnoreCase("prod")) {
				WebWrapper.typeInField(TouchXLoginPage.getPassword(), new Configuration().passwordProd());	
			}
			else {
				throw new RuntimeException("Impossible to compile the field");
			}
	    }
    	 
	
	public static void clickOnSignIn() {
    	WebWrapper.clickOn(TouchXLoginPage.getSignInButton());
    	driver.switchTo().defaultContent();
    	
    	
    }
	
	public static void loginBaseTouchX(String env) throws InterruptedException {
		VersonixMethodsB2C.searchTagNotClickableAndClick("height: 28px","flt-clip");
		Report.passStep("Click On Sign In ");
		WebWrapper.waitForJavascript();
		TouchXLoginAction.setUsername(env);
		Report.passStep("Insert Username");
		TouchXLoginAction.setPassword(env);
		Report.passStep("Insert Password");
		TouchXLoginAction.clickOnSignIn();
		Report.passStep("Click On Sign In Button");
		WebWrapper.waitForJavascript();
		Thread.sleep(3000);
	}
	
	

}
