package globalSetup;

import java.awt.AWTException;

import org.openqa.selenium.By;

import wrappers.WebWrapper;

public  class  startPageProd {
	
	
	public static void startPageProd() throws AWTException, InterruptedException {
		
		setupDriver.driver.get(new Configuration().URLProd);
		WebWrapper.clickOn(setupDriver.driver.findElement(By.id("didomi-notice-agree-button")));
		
		//setupDriver.driver.findElement(By.id("didomi-notice-agree-button")).click();
	}
}
