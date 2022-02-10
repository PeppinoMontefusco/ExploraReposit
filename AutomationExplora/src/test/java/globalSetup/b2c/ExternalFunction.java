package globalSetup.b2c;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
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
	
    public static class Email {
        public String subject, body;
        public LocalDateTime timestamp;

        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }
	
	
	public static void getRecoveryEmails(String md5) throws UnirestException, InterruptedException {
		HttpResponse<JsonNode> response = Unirest.get("https://privatix-temp-mail-v1.p.rapidapi.com/request/mail/id/"+md5+"/") 
				             .header("x-rapidapi-host", "privatix-temp-mail-v1.p.rapidapi.com") 
				             .header("x-rapidapi-key", "ae7a697843msh7aed4952885c1cfp1170cbjsn5ac0900804e1") 
				             .asJson();
		
		List<Email> emailsWithTimestamp = new ArrayList<>();
		
            
            var emails = response.getBody().getArray();
            
            
            
            
            for (int i = 0; i < emails.length(); i++) {
                var jsonObject = emails.getJSONObject(i);
                Email email = new Email();
                email.body = jsonObject.getString("mail_text_only");
                email.subject = jsonObject.getString("mail_subject");
                email.timestamp =
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(jsonObject.getLong("mail_timestamp") * 1000),
                                TimeZone.getDefault().toZoneId());
                emailsWithTimestamp.add(email);
            }

        
        
             Email email=emailsWithTimestamp.stream()
                .filter(x -> ChronoUnit.MINUTES.between(x.timestamp, LocalDateTime.now()) < 2)
                .max(Comparator.comparing(Email::getTimestamp)).orElse(null);
		
		
		var pattern = Pattern.compile("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(https:\\/\\/stage\\.mscnextgenlux\\.com\\/it\\/en\\/reset-password.*?)\\1");
		
		var match = pattern.matcher(email.body);
		if (match.find()) {
		    String url = match.group(2);
		    driver.get(url); 
		    }
		
	}
	
	public static void getRegistrationEmails(String md5) throws UnirestException, InterruptedException {
		HttpResponse<JsonNode> response = Unirest.get("https://privatix-temp-mail-v1.p.rapidapi.com/request/mail/id/"+md5+"/") 
				             .header("x-rapidapi-host", "privatix-temp-mail-v1.p.rapidapi.com") 
				             .header("x-rapidapi-key", "ae7a697843msh7aed4952885c1cfp1170cbjsn5ac0900804e1") 
				             .asJson();
		
		List<Email> emailsWithTimestamp = new ArrayList<>();
		
            
            var emails = response.getBody().getArray();
            
            
            
            
            for (int i = 0; i < emails.length(); i++) {
                var jsonObject = emails.getJSONObject(i);
                Email email = new Email();
                email.body = jsonObject.getString("mail_text_only");
                email.subject = jsonObject.getString("mail_subject");
                email.timestamp =
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(jsonObject.getLong("mail_timestamp") * 1000),
                                TimeZone.getDefault().toZoneId());
                emailsWithTimestamp.add(email);
            }

        
        
             Email email=emailsWithTimestamp.stream()
                .filter(x -> ChronoUnit.MINUTES.between(x.timestamp, LocalDateTime.now()) < 2)
                .max(Comparator.comparing(Email::getTimestamp)).orElse(null);
		
		var pattern = Pattern.compile("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(https:\\/\\/idpb2c.*?)\\1");
		
		
		var match = pattern.matcher(email.body);
		if (match.find()) {
		    String url = match.group(2);
		    driver.get(url);
		    }
		
	}
	
	
}
	
	
	

