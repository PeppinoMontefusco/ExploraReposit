package globalSetup.b2c;

import org.openqa.selenium.By;

import wrappers.WebWrapper;

public  class  startPage {
	
	
	public static void startPage() {
		
		setupDriver.driver.get(new Configuration().URL);
		WebWrapper.clickOn(setupDriver.driver.findElement(By.id("didomi-notice-agree-button")));
		//setupDriver.driver.findElement(By.id("didomi-notice-agree-button")).click();
	}
}
