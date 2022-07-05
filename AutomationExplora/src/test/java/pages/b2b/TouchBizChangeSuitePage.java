package pages.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.setupDriver;

public class TouchBizChangeSuitePage extends setupDriver {

	public static WebElement getContinue(){
		return driver.findElements(By.className("ui-btn-j")).get(5);
		
	
}
}