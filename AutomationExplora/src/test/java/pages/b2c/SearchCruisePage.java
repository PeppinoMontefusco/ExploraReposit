package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;

public class SearchCruisePage extends setupDriver {
	
	public static WebElement getDestinationSelect() {
		int destination= Integer.valueOf(ExternalFunction.getRandomInt(0, 7));
		return driver.findElements(By.className("destinationName")).get(destination);
		}
	
	public static WebElement getSelectAndCloseButton() {
		return driver.findElements(By.className("cta-gold-btn")).get(0);
		}
	
	public static WebElement getSearchCruiseButton() {
		return driver.findElements(By.className("quickBooking__guestBtn")).get(0);
		}
    
}
