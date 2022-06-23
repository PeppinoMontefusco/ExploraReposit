package pages.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.setupDriver;

public class TouchBizSearchCruisePage extends setupDriver {

	public static WebElement getDestination(){
		return driver.findElements(By.className("filterable-select")).get(3);
	}
	
}
