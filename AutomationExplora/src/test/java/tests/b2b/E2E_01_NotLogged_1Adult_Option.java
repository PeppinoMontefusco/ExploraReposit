package tests.b2b;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.mashape.unirest.http.exceptions.UnirestException;
import globalSetup.API;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import wrappers.TestListener;


@Listeners(TestListener.class)


public class E2E_01_NotLogged_1Adult_Option extends setupDriver {
	
	@Test
	public static void bookingFlow1adultOptionNotLogged() throws InterruptedException, AWTException, UnirestException, IOException {
		//test=TestManager.startTest("E2E_B2B_01", "E2E B2B Not Logged: Scenario 1 Adult - Option Creation", "E2E_B2B");
		//startPageB2B.startPageB2B();
		API.destinationB2B();
		ArrayList<String> ciao=new ArrayList<String>();
		ciao=API.destinationB2B();
		System.out.println(ciao.size());
		String Ciao=ExternalFunction.getRandomInt(0,ciao.size()-1);
		int ciaoo=Integer.parseInt(Ciao);
		System.out.println(Ciao);
		
		String ciao2=ciao.get(ciaoo);
		System.out.println(ciao2);

	}
}

