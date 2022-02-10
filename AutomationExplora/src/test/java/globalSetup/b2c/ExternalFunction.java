package globalSetup.b2c;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;

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
	
	public static String getEmails(String md5) throws UnirestException {
		HttpResponse<JsonNode> response = Unirest.get("https://privatix-temp-mail-v1.p.rapidapi.com/request/mail/id/"+md5+"/") 
				             .header("x-rapidapi-host", "privatix-temp-mail-v1.p.rapidapi.com") 
				             .header("x-rapidapi-key", "ae7a697843msh7aed4952885c1cfp1170cbjsn5ac0900804e1") 
				             .asJson();
		JSONArray emails= response.getBody().getArray();
		JSONObject email = emails.getJSONObject(0);
		
		System.out.println(email);
		
		var pattern = Pattern.compile("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(https:\\/\\/idpb2c.*?)\\1");
		var match = pattern.matcher(email.getString("mail_text_only"));
		if (match.find()) {
		    String url = match.group(2);
		    driver.get(url);
		    System.out.println(url);
		}
		
		
	return "";
		
	}
	
	
}
	
	
	

