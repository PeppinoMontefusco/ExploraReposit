package pages.b2b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.setupDriver;

public class HomePage extends setupDriver {
	
	public static WebElement closePopupButton() {
		WebElement a = driver.findElements(By.className("icon-explora-close")).get(0);
		return a;
		
		}
	
	public static WebElement getBookingSuiteButton() {
		return driver.findElement(By.xpath("//*[text()='Booking Suite']"));
		
		}
	
	public static WebElement getMyDashboardButton() {
		return driver.findElement(By.xpath("//*[text()='My Dashboard']"));
		
		}
	
	public static WebElement getContactUsButton() {
		return driver.findElement(By.xpath("//*[text()='Contact Us']"));
		
		}
	
	public static WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//*[title()='Log out']"));
	}
}
