package pages.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.setupDriver;

public class AdobeHomePageB2BPage extends setupDriver {
	
	
	public static WebElement getBookNowButton() {
		return driver.findElements(By.className("cta-navy-btn")).get(0);
		
		}
	
	
	
	public static WebElement closePopupButton() {
		return driver.findElements(By.className("icon-explora-close")).get(0);
		
		}
	
	public static WebElement getBookingSuiteButton() {
		return driver.findElement(By.xpath("//*[text()='Booking Suite']"));
		
		}
	
	public static WebElement getMyDashboardButton() {
		return driver.findElement(By.xpath("//*[text()='My Dashboard']"));
		
		}
	
	public static WebElement getContactUsButton() {
		return driver.findElement(By.xpath("//*[text()='Contact us']"));
		
		}
	
	public static WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//*[text()='Log out']"));
	}
}
