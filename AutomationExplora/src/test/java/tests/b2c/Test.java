package tests.b2c;
import java.io.IOException;
import java.util.List;

import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.SalesforceApi;
import tests.b2c.*;

public class Test {
	
	public static void main(String[] args) throws UnirestException {
		
		String id=SalesforceApi.getSessionId();
		SalesforceApi.getLeadId(id);
}
}