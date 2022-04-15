package tests.b2c;

import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.b2c.API;

public class TestAPI extends API {

	public static void main(String[] args) throws UnirestException{
		// TODO Auto-generated method stub
 
		
		String a= API.getCabinCategory("1939");
		System.out.println(a);
	}

}
