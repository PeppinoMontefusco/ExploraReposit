package pages.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.setupDriver;

public class TouchBizSearchCruisePage extends setupDriver {

	public static WebElement getDestination(){
		return driver.findElements(By.className("filterable-select")).get(3);
	}
	
	public static WebElement getCloseDestination () {
		
		return driver.findElements(By.className("ui-icon-delete")).get(4);
	}
public static WebElement getDateTo () {
		
		return driver.findElements(By.className("gwt-TextBox")).get(5);
	}
	
public static WebElement getSearchJourneyButton () {
	
	return driver.findElement(By.xpath("//*[text()='Search Journey']"));
}

public static WebElement getGridButton () {
	
	return driver.findElement(By.xpath("//*[text()='Grid']"));
}

public static WebElement getContinueButton () {
	
	return driver.findElement(By.xpath("//*[text()='Continue']"));
}
}
