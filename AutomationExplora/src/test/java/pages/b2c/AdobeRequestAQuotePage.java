package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.ExternalFunction;
import globalSetup.setupDriver;

public class AdobeRequestAQuotePage extends setupDriver {
	
	public static WebElement getFirstName() {

		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[2]/fieldset[1]/div[1]/div/div/input"));
		
	}

	public static WebElement getLastName() {

		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[2]/fieldset[1]/div[2]/div/div/input"));
	}

	public static WebElement getCountryCodeSelect() {

		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[2]/fieldset[1]/div[3]/div[1]/div/select"));
	}

	public static WebElement getMobileNumber() {

		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[2]/fieldset[1]/div[3]/div[2]/div/input"));
	}
	public static WebElement getEmail() {

		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[2]/fieldset[1]/div[4]/div/div/input"));
	}
	public static WebElement getQuoteSubject() {

		return driver.findElement(By.xpath("//form[@class='form theme--light']/div[2]/fieldset[1]/div[5]/div/div/select"));
	}
	
	public static WebElement getContactMethod() {
		String Prefix= ExternalFunction.getRandomInt(0, 1);
		int index=Integer.parseInt(Prefix);

		return driver.findElements(By.name("contactMethod")).get(index);
	}
	
	public static WebElement getPrivacyMarketing() {

		return driver.findElement(By.name("privacyMarketingConsent"));
	}
	
	
	public static WebElement getPrivacyProfiling() {

		return driver.findElement(By.name("privacyProfilingConsent"));
	}
	public static WebElement getSubmitButton() {
		return driver.findElement(By.xpath("//*[text()='Submit']"));
		}
	public static WebElement getCloseButton() {
		return driver.findElement(By.xpath("//*[text()='Close']"));
		}


}
