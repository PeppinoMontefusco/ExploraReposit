package globalSetup;

import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import freemarker.ext.util.ModelFactory;
import globalSetup.ExternalFunction.Email;
import wrappers.VersonixMethodsB2C;

public class API extends setupDriver {

	public static void getRecoveryEmails(String md5) throws UnirestException, InterruptedException {
		HttpResponse<JsonNode> response = Unirest.get("https://privatix-temp-mail-v1.p.rapidapi.com/request/mail/id/"+md5+"/") 
				             .header("x-rapidapi-host", "privatix-temp-mail-v1.p.rapidapi.com") 
				             .header("x-rapidapi-key", "ae7a697843msh7aed4952885c1cfp1170cbjsn5ac0900804e1") 
				             .asJson();
		
		List<ExternalFunction.Email> emailsWithTimestamp = new ArrayList<>();
		
	        
	        var emails = response.getBody().getArray();
	        
	        
	        
	        
	        for (int i = 0; i < emails.length(); i++) {
	            var jsonObject = emails.getJSONObject(i);
	            ExternalFunction.Email email = new ExternalFunction.Email();
	            email.body = jsonObject.getString("mail_text_only");
	            email.subject = jsonObject.getString("mail_subject");
	            email.timestamp =
	                    LocalDateTime.ofInstant(Instant.ofEpochMilli(jsonObject.getLong("mail_timestamp") * 1000),
	                            TimeZone.getDefault().toZoneId());
	            emailsWithTimestamp.add(email);
	        }
	
	    
	    
	         ExternalFunction.Email email=emailsWithTimestamp.stream()
	            .filter(x -> ChronoUnit.MINUTES.between(x.timestamp, LocalDateTime.now()) < 2)
	            .max(Comparator.comparing(ExternalFunction.Email::getTimestamp)).orElse(null);
		
		
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
		
		List<ExternalFunction.Email> emailsWithTimestamp = new ArrayList<>();
		
	        
	        var emails = response.getBody().getArray();
	        
	         
	        
	        
	        for (int i = 0; i < emails.length(); i++) {
	            var jsonObject = emails.getJSONObject(i);
	            ExternalFunction.Email email = new ExternalFunction.Email();
	            email.body = jsonObject.getString("mail_text_only");
	            email.subject = jsonObject.getString("mail_subject");
	            email.timestamp =
	                    LocalDateTime.ofInstant(Instant.ofEpochMilli(jsonObject.getLong("mail_timestamp") * 1000),
	                            TimeZone.getDefault().toZoneId());
	            emailsWithTimestamp.add(email);
	        }
	
	    
	    
	         ExternalFunction.Email email=emailsWithTimestamp.stream()
	            .filter(x -> ChronoUnit.MINUTES.between(x.timestamp, LocalDateTime.now()) < 2)
	            .max(Comparator.comparing(ExternalFunction.Email::getTimestamp)).orElse(null);
		
		var pattern = Pattern.compile("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(https:\\/\\/idpb2c.*?)\\1");
		
		
		var match = pattern.matcher(email.body);
		if (match.find()) {
		    String url = match.group(2);
		    driver.get(url);
		    }
		
	}
	

	
	public static ReadResponse getReadResponse(String bookingNumber) throws UnirestException {
		HttpResponse<String> response = Unirest.post("http://10.0.1.155:8082/ota/rest/OTA_ReadRQ")
				  .header("Content-Type", "application/xml")
				  .body("<OTA_ReadRQ EchoToken=\"1439812729310.795520\" PrimaryLangID=\"ENG\" Version=\"1\" xmlns=\"http://www.opentravel.org/OTA/2003/05\" >\r\n  <POS>\r\n    <Source><RequestorID Type=\"5\" ID_Context=\"SEAWARE\" ID=\"201\" /><BookingChannel Type=\"1\"></BookingChannel></Source>\r\n  </POS>\r\n   <ReadRequests>\r\n      <ReadRequest HistoryRequestedInd=\"false\">\r\n         <UniqueID ID=\""+bookingNumber+"\"  Type=\"14\" ID_Context=\"SEAWARE\"/>\r\n      </ReadRequest>\r\n   </ReadRequests>\r\n</OTA_ReadRQ>")
				  .asString();
				String a =response.getBody();
				JSONObject soapDatainJsonObject = XML.toJSONObject(a);
				return new ReadResponse (soapDatainJsonObject);
		
	}
	public static ArrayList<String> destinationB2B() throws UnirestException{
		HttpResponse<JsonNode> response = Unirest.post("http://10.0.1.155:3000/graphql")
				  .header("Accept-Encoding", "gzip, deflate, br")
				  .header("Content-Type", "application/json")
				  .header("Accept", "application/json")
				  .header("Connection", "keep-alive")
				  .header("DNT", "1")
				  .header("Origin", "http://10.0.1.155:3000")
				  .body("{\"query\":\"query AvailableVoyages{\\r\\n  destinations{\\r\\n    comments\\r\\n    \\r\\n  }\\r\\n}\\r\\n\",\"variables\":{}}")
				  .asJson();
		     var array=response.getBody().getObject();
		     JSONArray destinationlist = array.getJSONObject("data").getJSONArray("destinations");
		     int index=destinationlist.length();
		     
		     ArrayList<String> destinations = new ArrayList<String>();
		     for(int i = 0; i<index;i++) {
		    	 JSONObject destination=(JSONObject) destinationlist.get(i);
		    	 String text=destination.get("comments").toString();
		    	 
		    	 destinations.add(text);
		     }
		     
		    
		return destinations;
	}
	
	













}




