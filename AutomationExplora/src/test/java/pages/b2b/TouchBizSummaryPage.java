package pages.b2b;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.setupDriver;
import wrappers.WebWrapper;

public class TouchBizSummaryPage extends setupDriver {

	public static WebElement getStoreButton () {
		
		return driver.findElement(By.xpath("//*[text()='Store']"));
	}
	
	public static WebElement getNoButton () {
		
		return driver.findElement(By.xpath("/html/body/div[2]/div[40]/div/div[2]/div/div[1]/div[2]/a[1]"));
	}


	
	
	
}

