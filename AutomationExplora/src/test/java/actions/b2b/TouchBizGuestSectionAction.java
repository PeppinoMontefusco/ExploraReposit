package actions.b2b;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.API;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import pages.b2b.TouchBizCabinSelectionPage;
import pages.b2b.TouchBizGuestSectionPage;
import pages.b2b.TouchBizSearchCruisePage;
import wrappers.WebWrapper;

public class TouchBizGuestSectionAction extends setupDriver{

	public static void setFirstName() {
		String FirstName ="automation"+ExternalFunction.getRandomString(5);
       WebWrapper.typeInField(TouchBizGuestSectionPage.getFirstName(), FirstName);
		
	}
	
	public static void setLastName() {
		String LastName ="automation"+ExternalFunction.getRandomString(5);
       WebWrapper.typeInField(TouchBizGuestSectionPage.getLastName(), LastName);
		
	}
	
	public static void setDateOfBirth() {
		
       WebWrapper.typeInField(TouchBizGuestSectionPage.getDateOfBirth(), "01/01/1990");
		
	}
	
	public static void clickOnResidency() {
	WebWrapper.clickOn(TouchBizGuestSectionPage.getResidencySelect());
	}
	
	public static void selectResidencyFirstPax() {
		WebWrapper.clickOn(TouchBizGuestSectionPage.getResidencyFirstPax());
		}
	public static void selectResidencySecondPax() {
		WebWrapper.clickOn(TouchBizGuestSectionPage.getResidencySecondPax());
		}
	public static void clickOnNext() {
		WebWrapper.clickOn(TouchBizGuestSectionPage.getNextButton());
		}
	public static void clickOnSaveAndContinue() {
		WebWrapper.clickOn(TouchBizGuestSectionPage.getSaveAndContinue());
		}

	
	
	
}
