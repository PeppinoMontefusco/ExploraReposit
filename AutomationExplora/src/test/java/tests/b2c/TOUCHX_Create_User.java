package tests.b2c;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeRegistrationAction;
import actions.b2c.AdobeSearchCruiseAction;
import actions.b2c.TouchXCreateUserAction;
import actions.b2c.TouchXLoginAction;
import globalSetup.API;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import pages.b2c.AdobeLoginPage;
import wrappers.ApachePoiStyles;
import wrappers.ExcelName;
import wrappers.OutputLine;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)

public class TOUCHX_Create_User extends setupDriver {
	
	
	@Test
	public static void loginAndLogout() throws InterruptedException, AWTException, UnirestException {
		test=TestManager.startTest("TOUCHX_01",  "Login and Logout", "TouchX - My Account");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		AdobeSearchCruiseAction.clickOnDestination();
		Report.passStep("Select One Destination");
		AdobeSearchCruiseAction.clickOnSelectAndCloseDestination();
		Report.passStep("Click On Select And Close");
		AdobeSearchCruiseAction.clickSearchCruise();
		Report.passStep("Click On Search Cruise");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.startVersonixPage();
		VersonixMethodsB2C.searchTagNotClickableAndClick("height: 28px","flt-clip");
		Report.passStep("Click On Sign In ");
		TouchXCreateUserAction.clickOnCreateUserButton("test");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		TouchXCreateUserAction.setFirstName();
		TouchXCreateUserAction.setLastName();
		Thread.sleep(1000);
		TouchXCreateUserAction.setGender();
		String email=TouchXCreateUserAction.setEmail();
		TouchXCreateUserAction.setDateOfBirth();
		TouchXCreateUserAction.setPassword();
		TouchXCreateUserAction.setConfirmPassword();
		Thread.sleep(1000);
		TouchXCreateUserAction.setFlagMarketing();
		Thread.sleep(1000);
		TouchXCreateUserAction.setFlagProfiling();
		Thread.sleep(1000);
		TouchXCreateUserAction.clickOnStore();
		Thread.sleep(5000);
		String md5=ExternalFunction.getMd5Hash(email);
		System.out.println(md5);
		System.out.println(email);
		API.getRegistrationEmails(md5);
		
		Report.passStep("Click on Registration link in email");
		Thread.sleep(3000);
		AdobeRegistrationAction.clickCreateAccountSuccessClose();
		Report.passStep("Click on Close in Success Popup");
		
		//Login after registration
		
		AdobeHomePageAction.clickOnMyAccount();
		Report.passStep("Click On MyAccount");
		WebWrapper.typeInField(AdobeLoginPage.getLoginUsername(), email);
		Report.passStep("Insert Email");
		AdobeLoginAction.insertLoginPassword("test");
		Report.passStep("Insert Password");
		AdobeLoginAction.clickOnSignInButton();
		Report.passStep("Click on Sign In ");
		
		AdobeLoginAction.logOutBase();
		empdata.add(new OutputLine ( ApachePoiStyles.RESULTS,List.of(email, "Nicolino2017!!!" , "Create User"),ExcelName.USERS));
		empdata.add(new OutputLine (ApachePoiStyles.EMPTYROW ,List.of("" , "" ,"" ),ExcelName.USERS) );
		
		
}
}