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
import pages.b2b.TouchBizSearchCruisePage;
import wrappers.WebWrapper;

public class TouchBizChangeSuiteAction extends setupDriver{

	public static void clickOnContinue() {
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		   executor.executeScript("return document.getElementsByClassName('ui-btn-j')[6].click()");
		}
	
		
}
