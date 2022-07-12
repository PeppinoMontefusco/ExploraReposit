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
import pages.b2b.TouchBizSummaryPage;
import wrappers.WebWrapper;

public class TouchBizSummaryAction extends setupDriver{

	
	public static void clickOnStoreButton() {
		WebWrapper.clickOn(TouchBizSummaryPage.getStoreButton());
		}
	
	public static void clickOnYesButton() {
		WebWrapper.clickOn(TouchBizSummaryPage.getNoButton());
		}

	
	
	
}
