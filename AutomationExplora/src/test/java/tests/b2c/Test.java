package tests.b2c;

import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.b2c.API;

public class Test extends API {

	public static void main(String[] args) throws UnirestException  {
		
		API.getPaxData("2521");
	

	}

}
