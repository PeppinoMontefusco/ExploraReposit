package globalSetup.b2c;

import java.util.Random;

public class ExternalFunction extends setupDriver{

	public ExternalFunction() {
		// TODO Auto-generated constructor stub
	}

	
	public static String getRandomString(int n) {
		Random r = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyz"; 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) { sb.append(alphabet.charAt(r.nextInt(alphabet.length()))); } 
		String randomName = sb.toString();
		
		return randomName;
		
		
	}
}
