package globalSetup.b2c;

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
import globalSetup.b2c.ExternalFunction.Email;

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
	
	public static String getCabinNumber(String bookingNumber) throws UnirestException {
		
		HttpResponse<String> response = Unirest.post("http://10.0.1.155:8082/ota/rest/OTA_ReadRQ")
		  .header("Content-Type", "application/xml")
		  .body("<OTA_ReadRQ EchoToken=\"1439812729310.795520\" PrimaryLangID=\"ENG\" Version=\"1\" xmlns=\"http://www.opentravel.org/OTA/2003/05\" >\r\n  <POS>\r\n    <Source><RequestorID Type=\"29\" ID_Context=\"SEAWARE\" ID=\"4821\" /><BookingChannel Type=\"1\"></BookingChannel></Source>\r\n  </POS>\r\n   <ReadRequests>\r\n      <ReadRequest HistoryRequestedInd=\"false\">\r\n         <UniqueID ID=\""+bookingNumber+"\"  Type=\"14\" ID_Context=\"SEAWARE\"/>\r\n      </ReadRequest>\r\n   </ReadRequests>\r\n</OTA_ReadRQ>")
		  .asString();
		String a =response.getBody();
		JSONObject soapDatainJsonObject = XML.toJSONObject(a);
		JSONObject cabin =soapDatainJsonObject.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:SailingInfo").getJSONObject("vx:SelectedCategory").getJSONObject("vx:SelectedCabin");
		return cabin.get("CabinNumber").toString();
		
		
	}
	
public static String getStatusBooking(String bookingNumber) throws UnirestException {
		
		HttpResponse<String> response = Unirest.post("http://10.0.1.155:8082/ota/rest/OTA_ReadRQ")
		  .header("Content-Type", "application/xml")
		  .body("<OTA_ReadRQ EchoToken=\"1439812729310.795520\" PrimaryLangID=\"ENG\" Version=\"1\" xmlns=\"http://www.opentravel.org/OTA/2003/05\" >\r\n  <POS>\r\n    <Source><RequestorID Type=\"29\" ID_Context=\"SEAWARE\" ID=\"4821\" /><BookingChannel Type=\"1\"></BookingChannel></Source>\r\n  </POS>\r\n   <ReadRequests>\r\n      <ReadRequest HistoryRequestedInd=\"false\">\r\n         <UniqueID ID=\""+bookingNumber+"\"  Type=\"14\" ID_Context=\"SEAWARE\"/>\r\n      </ReadRequest>\r\n   </ReadRequests>\r\n</OTA_ReadRQ>")
		  .asString();
		String a =response.getBody();
		JSONObject soapDatainJsonObject = XML.toJSONObject(a);
		JSONObject status =soapDatainJsonObject.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:ReservationID");
		if( status.get("StatusCode").toString().equals("42")) {
			return "OPTION";
		}
		else if( status.get("StatusCode").toString().equals("49")) {
			return "BOOKED";
		}
		else {
			return null;
			
		}
		
		
	}
public static String getAmountBooking(String bookingNumber , String amountValue) throws UnirestException {
	
	HttpResponse<String> response = Unirest.post("http://10.0.1.155:8082/ota/rest/OTA_ReadRQ")
	  .header("Content-Type", "application/xml")
	  .body("<OTA_ReadRQ EchoToken=\"1439812729310.795520\" PrimaryLangID=\"ENG\" Version=\"1\" xmlns=\"http://www.opentravel.org/OTA/2003/05\" >\r\n  <POS>\r\n    <Source><RequestorID Type=\"29\" ID_Context=\"SEAWARE\" ID=\"4821\" /><BookingChannel Type=\"1\"></BookingChannel></Source>\r\n  </POS>\r\n   <ReadRequests>\r\n      <ReadRequest HistoryRequestedInd=\"false\">\r\n         <UniqueID ID=\""+bookingNumber+"\"  Type=\"14\" ID_Context=\"SEAWARE\"/>\r\n      </ReadRequest>\r\n   </ReadRequests>\r\n</OTA_ReadRQ>")
	  .asString();
	String  TotalAmount = null;
	String a =response.getBody();
	JSONObject soapDatainJsonObject = XML.toJSONObject(a);
	
	JSONArray amount =soapDatainJsonObject.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:PaymentsDue").getJSONArray("vx:PaymentDue");
	int index=amount.length()-2;
	
	for (int i=0; i<index ; i++) {
		JSONObject stringAmount=(JSONObject) amount.get(i);
		if(stringAmount.get("PaymentNumber").toString().equals(amountValue)) {
			
			TotalAmount= stringAmount.get("Amount").toString();
			break;
			
		}
		
}
		 if(TotalAmount==null) {
			 throw new RuntimeException("Amount not Available");
			 
}
		 return TotalAmount;


}

public static String getAmountMultiplePaymentsBooking(String bookingNumber) throws UnirestException {
	
	HttpResponse<String> response = Unirest.post("http://10.0.1.155:8082/ota/rest/OTA_ReadRQ")
	  .header("Content-Type", "application/xml")
	  .body("<OTA_ReadRQ EchoToken=\"1439812729310.795520\" PrimaryLangID=\"ENG\" Version=\"1\" xmlns=\"http://www.opentravel.org/OTA/2003/05\" >\r\n  <POS>\r\n    <Source><RequestorID Type=\"29\" ID_Context=\"SEAWARE\" ID=\"4821\" /><BookingChannel Type=\"1\"></BookingChannel></Source>\r\n  </POS>\r\n   <ReadRequests>\r\n      <ReadRequest HistoryRequestedInd=\"false\">\r\n         <UniqueID ID=\""+bookingNumber+"\"  Type=\"14\" ID_Context=\"SEAWARE\"/>\r\n      </ReadRequest>\r\n   </ReadRequests>\r\n</OTA_ReadRQ>")
	  .asString();
	double somma=0;
	String a =response.getBody();
	JSONObject soapDatainJsonObject = XML.toJSONObject(a);
	
	JSONArray amount =soapDatainJsonObject.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:PaymentOptions").getJSONArray("vx:PaymentOption");
	int index=amount.length();
	
     for(int i=0 ; i<index ; i++) {
    	 JSONObject stringAmount=(JSONObject) amount.get(i);
    	 double sum = Double.parseDouble(stringAmount.getJSONObject("vx:PaymentAmount").get("Amount").toString());
    	 somma=somma + sum;
     
     }
     
     String value =String.valueOf((int)somma);
     return value;

}
public static String getAmountSinglePaymentsBooking(String bookingNumber) throws UnirestException {
	
	HttpResponse<String> response = Unirest.post("http://10.0.1.155:8082/ota/rest/OTA_ReadRQ")
	  .header("Content-Type", "application/xml")
	  .body("<OTA_ReadRQ EchoToken=\"1439812729310.795520\" PrimaryLangID=\"ENG\" Version=\"1\" xmlns=\"http://www.opentravel.org/OTA/2003/05\" >\r\n  <POS>\r\n    <Source><RequestorID Type=\"29\" ID_Context=\"SEAWARE\" ID=\"4821\" /><BookingChannel Type=\"1\"></BookingChannel></Source>\r\n  </POS>\r\n   <ReadRequests>\r\n      <ReadRequest HistoryRequestedInd=\"false\">\r\n         <UniqueID ID=\""+bookingNumber+"\"  Type=\"14\" ID_Context=\"SEAWARE\"/>\r\n      </ReadRequest>\r\n   </ReadRequests>\r\n</OTA_ReadRQ>")
	  .asString();
	
	String a =response.getBody();
	JSONObject soapDatainJsonObject = XML.toJSONObject(a);
	
	JSONObject amount =soapDatainJsonObject.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:PaymentOptions").getJSONObject("vx:PaymentOption").getJSONObject("vx:PaymentAmount");
	String value =amount.get("Amount").toString();
	
	
     return value;

}

public static String getCabinCategory(String bookingNumber) throws UnirestException {
	
	HttpResponse<String> response = Unirest.post("http://10.0.1.155:8082/ota/rest/OTA_ReadRQ")
	  .header("Content-Type", "application/xml")
	  .body("<OTA_ReadRQ EchoToken=\"1439812729310.795520\" PrimaryLangID=\"ENG\" Version=\"1\" xmlns=\"http://www.opentravel.org/OTA/2003/05\" >\r\n  <POS>\r\n    <Source><RequestorID Type=\"29\" ID_Context=\"SEAWARE\" ID=\"4821\" /><BookingChannel Type=\"1\"></BookingChannel></Source>\r\n  </POS>\r\n   <ReadRequests>\r\n      <ReadRequest HistoryRequestedInd=\"false\">\r\n         <UniqueID ID=\""+bookingNumber+"\"  Type=\"14\" ID_Context=\"SEAWARE\"/>\r\n      </ReadRequest>\r\n   </ReadRequests>\r\n</OTA_ReadRQ>")
	  .asString();
	String a =response.getBody();
	JSONObject soapDatainJsonObject = XML.toJSONObject(a);
	JSONObject cabin =soapDatainJsonObject.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:SailingInfo").getJSONObject("vx:SelectedCategory").getJSONObject("vx:SelectedCabin");
	return cabin.get("CabinCategoryCode").toString();
	
	
}

public static ArrayList <String>  get1AdultData (String bookingNumber) throws UnirestException {
	HttpResponse<String> response = Unirest.post("http://10.0.1.155:8082/ota/rest/OTA_ReadRQ")
			  .header("Content-Type", "application/xml")
			  .body("<OTA_ReadRQ EchoToken=\"1439812729310.795520\" PrimaryLangID=\"ENG\" Version=\"1\" xmlns=\"http://www.opentravel.org/OTA/2003/05\" >\r\n  <POS>\r\n    <Source><RequestorID Type=\"29\" ID_Context=\"SEAWARE\" ID=\"4821\" /><BookingChannel Type=\"1\"></BookingChannel></Source>\r\n  </POS>\r\n   <ReadRequests>\r\n      <ReadRequest HistoryRequestedInd=\"false\">\r\n         <UniqueID ID=\""+bookingNumber+"\"  Type=\"14\" ID_Context=\"SEAWARE\"/>\r\n      </ReadRequest>\r\n   </ReadRequests>\r\n</OTA_ReadRQ>")
			  .asString();
	        ArrayList <String> paxdata = new ArrayList <String>();
			String a =response.getBody();
			JSONObject soapDatainJsonObject = XML.toJSONObject(a);
			JSONObject Name =soapDatainJsonObject.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:GuestDetails").getJSONObject("vx:GuestDetail").getJSONObject("vx:ContactInfo").getJSONObject("vx:PersonName");
			paxdata.add(Name.get("vx:GivenName").toString());
			paxdata.add(Name.get("vx:Surname").toString());
			JSONObject contact =soapDatainJsonObject.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:GuestDetails").getJSONObject("vx:GuestDetail").getJSONObject("vx:ContactInfo");
			paxdata.add(contact.get("PersonBirthDate").toString());
			
			paxdata.add(contact.get("vx:Email").toString());
			System.out.println(paxdata);
			return paxdata;
}

public static ArrayList <String>  getAllPaxData (String bookingNumber) throws UnirestException {
	HttpResponse<String> response = Unirest.post("http://10.0.1.155:8082/ota/rest/OTA_ReadRQ")
			  .header("Content-Type", "application/xml")
			  .body("<OTA_ReadRQ EchoToken=\"1439812729310.795520\" PrimaryLangID=\"ENG\" Version=\"1\" xmlns=\"http://www.opentravel.org/OTA/2003/05\" >\r\n  <POS>\r\n    <Source><RequestorID Type=\"29\" ID_Context=\"SEAWARE\" ID=\"4821\" /><BookingChannel Type=\"1\"></BookingChannel></Source>\r\n  </POS>\r\n   <ReadRequests>\r\n      <ReadRequest HistoryRequestedInd=\"false\">\r\n         <UniqueID ID=\""+bookingNumber+"\"  Type=\"14\" ID_Context=\"SEAWARE\"/>\r\n      </ReadRequest>\r\n   </ReadRequests>\r\n</OTA_ReadRQ>")
			  .asString();
	        ArrayList <String> paxdata = new ArrayList <String>();
			String a =response.getBody();
			JSONObject soapDatainJsonObject = XML.toJSONObject(a);
			JSONArray data =soapDatainJsonObject.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:GuestDetails").getJSONArray("vx:GuestDetail");
			int index=data.length();
			for(int i=0 ; i<index ; i++) {
		    	 JSONObject dati=(JSONObject) data.get(i);
		    	paxdata.add(dati.getJSONObject("vx:ContactInfo").getJSONObject("vx:PersonName").get("vx:GivenName").toString());
		    	paxdata.add(dati.getJSONObject("vx:ContactInfo").getJSONObject("vx:PersonName").get("vx:Surname").toString()); 
		    	paxdata.add(dati.getJSONObject("vx:ContactInfo").get("PersonBirthDate").toString()); 
		    	if(Integer.parseInt(dati.getJSONObject("vx:ContactInfo").get("Age").toString())>17) {
		    		paxdata.add(dati.getJSONObject("vx:ContactInfo").get("vx:Email").toString());
		    	}
		        
		     }
			
			return paxdata;
		
			
}


}




