package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;

public class RecoveryPage extends setupDriver{
	
	public static WebElement getRecoveryPasswordLink() {
		return driver.findElements(By.className("js-forgot-password")).get(0);
	}
	
	public static WebElement getRecoveryPasswordEmail() {
		return driver.findElement(By.id("account-recovery-username"));
	}
	
	public static WebElement getRecoveryPasswordResetButton() {
		return driver.findElement(By.xpath("//*[text()='RESET PASSWORD']"));
	}

}
