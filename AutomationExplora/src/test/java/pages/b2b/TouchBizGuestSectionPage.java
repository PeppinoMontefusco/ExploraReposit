package pages.b2b;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.setupDriver;
import wrappers.WebWrapper;

public class TouchBizGuestSectionPage extends setupDriver {

	static List  <WebElement> listaTextBox = new ArrayList <WebElement>();
	static List  <WebElement> listaSelect = new ArrayList <WebElement>();

	public static void getListOfGuestInfoTextBox(){
		listaTextBox = WebWrapper.getListOfVisibleElements(driver.findElements(By.className("gwt-TextBox")));
	}
	
	public static WebElement getFirstName () {
		return listaTextBox.get(1);
	}
	
	public static WebElement getLastName () {
		return listaTextBox.get(2);
	}
	
	public static WebElement getDateOfBirth () {
		return listaTextBox.get(6);
	}
	
	public static void getListOfGuestInfoSelect(){
		listaSelect = WebWrapper.getListOfVisibleElements(driver.findElements(By.className("filterable-select")));
	}
	
	public static WebElement getResidencySelect() {
		return listaSelect.get(4);
	}
	public static WebElement getResidencyFirstPax() {
		return driver.findElement(By.xpath("/html/body/div[2]/div[20]/div[25]/div/ul/li[6]/a"));
	}
	
	public static WebElement getResidencySecondPax() {
		return driver.findElement(By.xpath("/html/body/div[2]/div[20]/div[47]/div/ul/li[3]/a"));
	}
	public static WebElement getNextButton() {
		return driver.findElements(By.className("ui-btn-j")).get(7);
	}
	public static WebElement getSaveAndContinue() {
		return driver.findElement(By.xpath("//*[text()='Save & Continue']"));
		//return driver.findElements(By.className("ui-btn-g")).get(19);
	}
	
	
}

