package actions.b2b;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.API;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import pages.b2b.TouchBizSearchCruisePage;
import wrappers.WebWrapper;

public class TouchBizSearchCruiseAction extends setupDriver{

	public static void clickOnDestinationButton() {
		WebWrapper.clickOn(TouchBizSearchCruisePage.getDestination());
		}
	
	public static void selectRandomDestination() throws UnirestException {
		ArrayList<String> destinations= new ArrayList<String>();
		destinations=API.destinationB2B();
		String randomNumber=ExternalFunction.getRandomInt(0,destinations.size()-1);
		int index=Integer.parseInt(randomNumber);
		String destination=destinations.get(index);
		WebWrapper.clickOn(driver.findElement(By.xpath("//*[text()='"+destination+"']")));

	}
	public static void clickOnCloseDestination() throws InterruptedException{
		WebWrapper.clickOnElementNotClickable(TouchBizSearchCruisePage.getCloseDestination());
		
		}
	public static void ClickAndFilDateTo() throws InterruptedException{
		
		driver.findElements(By.className("gwt-TextBox")).get(5).click();
		driver.findElements(By.className("gwt-TextBox")).get(5).clear();
		driver.findElements(By.className("gwt-TextBox")).get(5).sendKeys("31/12/2024");
		
		}
	public static void clickOnSearchJourney() throws InterruptedException {
		WebWrapper.clickOn(TouchBizSearchCruisePage.getSearchJourneyButton());
		
		}
	public static void clickOnGridButton() throws InterruptedException{
		WebWrapper.clickOn(TouchBizSearchCruisePage.getGridButton());
		
		}
	public static void clickOnRandomCruise() {
		long num = WebWrapper.getLengthOfElement("document.getElementsByClassName('checkbox-rowsel').length");
		String check =ExternalFunction.getRandomInt(0, (int) (num-1));
		long random = Integer.parseInt(check);
		WebWrapper.clickOn(driver.findElements(By.className("checkbox-rowsel")).get((int) random));
		
	}
	public static void clickOnContinueButton() throws InterruptedException {
		WebWrapper.clickOnElementNotClickable(TouchBizSearchCruisePage.getContinueButton());
	}
	
}
