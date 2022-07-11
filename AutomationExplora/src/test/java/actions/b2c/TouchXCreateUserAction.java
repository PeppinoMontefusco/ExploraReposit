package actions.b2c;

import globalSetup.Configuration;
import globalSetup.setupDriver;
import pages.b2c.TouchXCreateUserPage;
import pages.b2c.TouchXLoginPage;
import wrappers.Report;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

public class TouchXCreateUserAction extends setupDriver {
	
		
	public static void clickOnCreateUserButton(String env) {
		if (env.equalsIgnoreCase("test")) {
			driver.switchTo().frame(1);
			WebWrapper.clickOn(TouchXCreateUserPage.getCreateUserButton());
		}else if (env.equalsIgnoreCase("prod")) {
			driver.switchTo().frame(2);
			WebWrapper.clickOn(TouchXCreateUserPage.getCreateUserButton());	
		}
		else {
			throw new RuntimeException("Impossible to compile the field");
		}
    }
	

}
