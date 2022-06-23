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
	
	
}
