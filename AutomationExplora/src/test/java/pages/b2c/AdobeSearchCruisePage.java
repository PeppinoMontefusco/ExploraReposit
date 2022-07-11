package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.ExternalFunction;
import globalSetup.setupDriver;

public class AdobeSearchCruisePage extends setupDriver {
	
	public static WebElement getDestinationSelect() {
		int destination= Integer.valueOf(ExternalFunction.getRandomInt(0, 7));
		return driver.findElements(By.className("destinationName")).get(destination);
		}
	
	public static WebElement getDateOfTravelButton() {
		return driver.findElements(By.className("quickBooking__main")).get(1);
		
	}
	
	public static WebElement getMonthSelect() {
		int month= Integer.valueOf(ExternalFunction.getRandomInt(0, 3));
		return driver.findElements(By.className("quickBooking__months")).get(1).findElements(By.className("available")).get(month);
	}
	public static WebElement getGuestSelection() {
		return driver.findElements(By.className("quickBooking__main")).get(2);
		
	}
	
	public static WebElement getIncreaseChild() {
		return driver.findElements(By.className("increment")).get(1);
		
	}
	
	public static WebElement getDecreaseAdult() {
		return driver.findElements(By.className("decrement")).get(0);
		
	}
	
	public static WebElement getIncreaseInfant() {
		return driver.findElements(By.className("increment")).get(2);
		
	}
	
	
	public static WebElement getSelectAndCloseDestinationButton() {
		return driver.findElements(By.className("cta-gold-btn")).get(0);
		
		//return driver.findElements(By.className("cta-navy-btn")).get(2);
		}
	public static WebElement getSelectAndCloseDateOfTravelButton() {
		return driver.findElements(By.className("cta-gold-btn")).get(1);
		}
	public static WebElement getSearchCruiseButton() {
		return driver.findElements(By.className("quickBooking__guestBtn")).get(0);
		
		}
    
	
}
