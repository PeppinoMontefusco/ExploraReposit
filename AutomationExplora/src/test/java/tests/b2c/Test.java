package tests.b2c;

import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.b2c.API;
import wrappers.VersonixMethodsB2C;

public class Test extends VersonixMethodsB2C {

	public static void main(String[] args) throws UnirestException  {
		
		VersonixMethodsB2C.clickOnLabelRandom("Book");

	}

}
