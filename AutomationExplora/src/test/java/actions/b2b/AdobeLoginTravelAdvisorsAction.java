package actions.b2b;

import globalSetup.Configuration;
import globalSetup.setupDriver;
import pages.b2b.AdobeLoginTravelAdvisorsPage;
import pages.b2c.AdobeLoginPage;
import wrappers.Report;
import wrappers.WebWrapper;

public class AdobeLoginTravelAdvisorsAction extends setupDriver {

	public static void insertLoginUsernameB2B(String env) {
if (env.equalsIgnoreCase("test")) {
	    	
	WebWrapper.typeInField(AdobeLoginTravelAdvisorsPage.getUsernameTravelAdvisors(),
			new Configuration().usernameB2B());	    	
	} else if(env.equalsIgnoreCase("prod")) {
		WebWrapper.typeInField(AdobeLoginTravelAdvisorsPage.getUsernameTravelAdvisors(),
				new Configuration().getUsernameB2BProd());	    	
		}else
	    	{
	    		throw new RuntimeException("Wrong Environment");
	    	}
	

	}

	public static void insertLoginPassowrdB2B(String env) throws InterruptedException {
		if (env.equalsIgnoreCase("test")) {
	    	
			WebWrapper.typeInField(AdobeLoginTravelAdvisorsPage.getPasswordTravelAdvisors(),
					new Configuration().passwordB2B());    	
			} else if(env.equalsIgnoreCase("prod")) {
				WebWrapper.typeInField(AdobeLoginTravelAdvisorsPage.getPasswordTravelAdvisors(),
						new Configuration().getPasswordB2BProd());	    	
				}else
			    	{
			    		throw new RuntimeException("Wrong Environment");
			    	}
		
	}

	public static void clickOnSignInButtonB2B() {
		WebWrapper.clickOn(AdobeLoginTravelAdvisorsPage.getSignInTravelAdvisors());
	}
	
	public static void clickOnRegisterAsNewAdvisor() {
		WebWrapper.clickOn(AdobeLoginTravelAdvisorsPage.getRegisterButton());
	}
	
	public static void loginBaseB2B(String env) throws InterruptedException {
		AdobeLoginTravelAdvisorsAction.insertLoginUsernameB2B(env);
		Report.passStep("Insert Username");
	    AdobeLoginTravelAdvisorsAction.insertLoginPassowrdB2B(env);
	    Report.passStep("Insert Password");
	    AdobeLoginTravelAdvisorsAction.clickOnSignInButtonB2B();
	    Report.passStep("Click On Sign In Button");
	    AdobeHomePageB2BAction.clickOnClosePopUp();
	    Report.passStep("Click On Close Pop Up");
	}
}
