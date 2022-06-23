package globalSetup;

import java.awt.AWTException;

import org.openqa.selenium.By;

import wrappers.WebWrapper;

public  class  startPageB2B {
	
	
	public static void startPage() throws AWTException, InterruptedException {
		
		setupDriver.driver.get(new Configuration().URLB2B);
		WebWrapper.clickOn(setupDriver.driver.findElement(By.id("didomi-notice-agree-button")));
		
	}
}
