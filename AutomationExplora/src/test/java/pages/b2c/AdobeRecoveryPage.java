package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;

public class AdobeRecoveryPage extends setupDriver{
	
	public static WebElement getRecoveryPasswordLink() {
		return driver.findElements(By.className("js-forgot-password")).get(0);
	}
	
	public static WebElement getRecoveryPasswordEmail() {
		return driver.findElement(By.id("account-recovery-username"));
	}
	
	public static WebElement getRecoveryPasswordResetButton() {
		return driver.findElement(By.xpath("//*[text()='RESET PASSWORD']"));
	}
	
	public static WebElement getRecoveryPasswordNewPassword() {
		return driver.findElement(By.name("newPassword"));
	}
	
	public static WebElement getRecoveryPasswordConfirmNewPassword() {
		return driver.findElement(By.name("confirmPassword"));
	}
	
	public static WebElement getRecoveryPasswordUpdatePasswordButton() {
		return driver.findElements(By.className("button-primary")).get(0);
	}
	
	public static WebElement getRecoveryPasswordUpdateSignInButton() {
		return driver.findElements(By.className("go-to-signin")).get(0);
	}
	
	

}
