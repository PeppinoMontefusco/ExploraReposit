package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import globalSetup.b2c.setupDriver;
import wrappers.WebWrapper;

public class AdobeHomePage extends setupDriver {

	public static WebElement getMyAccountButton() {
	return driver.findElements(By.className("myAccount")).get(0);
	}

	public static WebElement getMyAccountLoggedButton() throws InterruptedException {
	Thread.sleep(3000);
	 //WebWrapper.wait.until(ExpectedConditions.elementToBeClickable(By.className("myAccountLogged")));
	 //WebWrapper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("myAccountLogged")));
	return driver.findElements(By.className("myAccountLogged")).get(0);
	}

	public static WebElement getBookAJourneyButton() {
		return driver.findElements(By.className("cta")).get(0);
	}
	
	public static WebElement getQuickSearchButton() {
		return driver.findElements(By.className("quickBooking__btn")).get(0);
	}
	
	public static WebElement joinUsButton() {
		return driver.findElements(By.className("joinUs")).get(0);
	}
	
	public static WebElement talkWithUs() {
		return driver.findElements(By.className("icon-explora-talk-to-us")).get(0);
				
	}

}
