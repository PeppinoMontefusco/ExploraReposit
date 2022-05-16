package tests.b2c;

import java.awt.AWTException;
import java.util.ArrayList;

import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.b2c.API;
import globalSetup.b2c.startPage;
import wrappers.VersonixMethodsB2C;

public class Test extends VersonixMethodsB2C {

	public static void main(String[] args) throws UnirestException, InterruptedException, AWTException  {
		
		driver.get("https://explorajourneys.com/it/en.html");
		VersonixMethodsB2C.checkCountry();
		
		

	}

}
