package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;

public class AdobeTalkWithUsPage extends setupDriver {

	
	public static WebElement getRequestABrochureButton() {
		return driver.findElement(By.xpath("//*[text()='REQUEST A BROCHURE']"));
		}
	
	public static WebElement getRequestAQuoteButton() {
		return driver.findElement(By.xpath("//*[text()='REQUEST A QUOTE']"));
		}
}
