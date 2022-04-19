package globalSetup.b2c;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


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
		
	public static String getRandomNumber(int n) {
		Random r = new Random();
		String number = "0123456789"; 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) { sb.append(number.charAt(r.nextInt(number.length()))); } 
		String randomNumber = sb.toString();
		
		return randomNumber;
		}


	
	public static String getRandomInt(int min , int max) {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		String randomNum = "" + tlr.nextInt(min, max + 1);
		return randomNum;
	
	}
	
	public static String getMd5Hash(String email) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(StandardCharsets.UTF_8.encode(email));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (Exception e) {
            return null;
        }
        
      }
	
    public static class Email {
        public String subject, body;
        public LocalDateTime timestamp;

        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }
    
    public static String getSumOfStringValue(String arg1, String arg2) {
    	Double one =Double.parseDouble(arg1);
    	Double two = Double.parseDouble(arg2);
    	Integer somma =(int) (one+two);
		return String.valueOf(somma);
    	
    	
    }
	
	
	
	
}
	
	
	

