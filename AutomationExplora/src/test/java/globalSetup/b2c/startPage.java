package globalSetup.b2c;

import org.openqa.selenium.By;

public  class  startPage {
	
	
	public static void startPage() {
		
		setupDriver.driver.get(new Configuration().URL);
		setupDriver.driver.findElement(By.id("didomi-notice-agree-button")).click();
	}
}
