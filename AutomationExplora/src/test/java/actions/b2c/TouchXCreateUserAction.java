package actions.b2c;

import globalSetup.Configuration;
import globalSetup.ExternalFunction;
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
	
	public static void setFirstName () throws InterruptedException {
		String firstname = "Automation"+ ExternalFunction.getRandomString(4);
		VersonixMethodsB2C.searchInputAndCompile("First", firstname);
	}
	
	public static void setLastName () throws InterruptedException {
		String lastname = "Automation"+ ExternalFunction.getRandomString(4);
		VersonixMethodsB2C.searchInputAndCompile("Last", lastname);
	}
	
	public static void setGender () throws InterruptedException {
		
		VersonixMethodsB2C.clickOnLabel("Other");
	}
	public static String setEmail () throws InterruptedException {
		String email = "Automation"+ ExternalFunction.getRandomString(4)+"@folllo.com";
		VersonixMethodsB2C.searchInputAndCompile("Email", email);
		return email;
	}
	
	
	public static void setDateOfBirth () throws InterruptedException {
		
		VersonixMethodsB2C.searchInputAndCompile("Date", "01011990");
	}
	
public static void setPassword () throws InterruptedException {
		
		VersonixMethodsB2C.searchInputAndCompile("Password", new Configuration().password());
	}
	
public static void setConfirmPassword () throws InterruptedException {
	
	VersonixMethodsB2C.searchInputAndCompile("Confirm", new Configuration().password());
}
public static void setFlagMarketing () throws InterruptedException {
	
	VersonixMethodsB2C.clickOnContainsLabel("Marketing");
}

public static void setFlagProfiling () throws InterruptedException {
	
	VersonixMethodsB2C.clickOnContainsLabel("Profiling");
}

public static void clickOnStore () throws InterruptedException {
	
	VersonixMethodsB2C.clickOnLabel("Store");
}
	
	

}
