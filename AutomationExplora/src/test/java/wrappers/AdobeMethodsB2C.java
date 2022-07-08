package wrappers;

import org.openqa.selenium.By;

import globalSetup.Configuration;
import globalSetup.setupDriver;

public class AdobeMethodsB2C extends setupDriver {

	public static void checkCountry(String url) throws InterruptedException {
		String[] list= {"Italy","International", "Belgium", "Canada", "Germany", "Ireland", "Netherlands", "Spain", "Switzerland", "United Kingdom", "USA"};
		String[] code= {"it","int","be","ca","de","ie","nl","es","ch","uk","us"};
		int index=list.length;
		for(int i=0;i<index;i++) {
			WebWrapper.clickOn(driver.findElements(By.className("countrySelection")).get(0));
			Thread.sleep(1000);
			WebWrapper.clickOnElementNotClickable(driver.findElement(By.xpath("//*[text()='"+list[i].toString()+"']")));
			Thread.sleep(1000);
			if(driver.getCurrentUrl().equals(url+code[i]+"/en.html")) {
				Report.passStep("Check country "+list[i]+" is ok");
			}
			else {
				throw new RuntimeException("Check country "+list[i]+" is not ok");
			}
		}
	}

}
