package actions.b2b;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.API;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import pages.b2b.TouchBizCabinSelectionPage;
import pages.b2b.TouchBizSearchCruisePage;
import wrappers.WebWrapper;

public class TouchBizCabinSelectionAction extends setupDriver{

	public static void clickOnContinue() {
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		   executor.executeScript("return document.getElementsByClassName('ui-btn-j')[5].click()");
		}

	public static void clickOnRandomSubCategory() {
		List  <WebElement> lista = WebWrapper.getListOfVisibleElements(driver.findElements(By.className("ivx-plus")));
		int numero = lista.size();
		String check =ExternalFunction.getRandomInt(0, (numero-1));
		int random = Integer.parseInt(check);
		WebWrapper.clickOn(lista.get(random));
		
	}

	public static void clickOnRandomCategory() {
		long num = WebWrapper.getLengthOfElement("$( \"a:contains('Show Available Categories')\" ).length");
		String check =ExternalFunction.getRandomInt(0, (int) (num-1));
		long random = Integer.parseInt(check);
		WebWrapper.clickOn(driver.findElements(By.xpath("//*[text()='Show Available Categories']")).get((int) random));
		
	}
	
		
}
