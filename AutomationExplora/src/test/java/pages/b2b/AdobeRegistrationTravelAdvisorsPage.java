package pages.b2b;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.setupDriver;
import wrappers.WebWrapper;

public class AdobeRegistrationTravelAdvisorsPage extends setupDriver {

	
	public static WebElement getSelectTitle() {
		return driver.findElement(By.id("webTitle"));
		
	}
	public static WebElement getRegFirstName() {
		return driver.findElement(By.id("regFirstname"));
		
	}
	public static WebElement getRegLastName() {
		return driver.findElement(By.id("regLastname"));
		
	}
	
	public static WebElement getCountryOfResidenceSelect() {
		return driver.findElement(By.id("regCountry"));
		
	}
	
	public static WebElement getCountryCodeSelect() {
		return driver.findElement(By.id("regCountryCode"));
		
	}
	
	public static WebElement getPhoneNumber() {
		return driver.findElement(By.name("phone"));
		
	}
	
	public static WebElement getTravelAgencyName() {
		return driver.findElement(By.id("regTravelAgencyName"));
		
	}
	
	public static WebElement getRadioAgencyOnline() {
		return driver.findElements(By.className("size--small")).get(0);
		
	}
	
	public static WebElement getAgencyAddress() {
		return driver.findElements(By.className("pac-target-input")).get(0);
		
	}
	public static WebElement getZipCode() {
		return driver.findElement(By.id("regZipCode"));
		
	}
	public static WebElement getAgencyCity() {
		return driver.findElement(By.id("regCity"));
		
	}
	public static WebElement getAgencyAddress1() {
		return driver.findElement(By.id("regTravelAgencyAddress1"));
		
	}
	public static WebElement getEmail() {
		return driver.findElement(By.id("regEmail"));
		
	}
	public static WebElement getConfirmEmail() {
		return driver.findElement(By.id("regConfirmEmail"));
		
	}
	public static WebElement getMarketingConsent() {
		return driver.findElement(By.name("privacyMarketingConsent"));
		
	}
	public static WebElement getProfilingConsent() {
		return driver.findElement(By.name("privacyProfilingConsent"));
		
	}
	
	public static WebElement getSubmitButton() {
		return driver.findElements(By.className("btn--size-large")).get(0);
		
	}
	public static WebElement getPopupBackButton() throws InterruptedException {
		List <WebElement> list=null;
		do{
			list = WebWrapper.getListOfVisibleElements(driver.findElements(By.className("space-left--auto")));
		}while(list.isEmpty());
		 return list.get(0);
		 
		}
}
