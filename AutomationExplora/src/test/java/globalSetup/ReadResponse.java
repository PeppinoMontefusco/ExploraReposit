package globalSetup;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadResponse {
        
	JSONObject read;
	
	 public ReadResponse(JSONObject read) {
		 this.read=read;
		 
	 }
	
	 
	 public String getCabinNumber() {
		 JSONObject cabin =read.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:SailingInfo").getJSONObject("vx:SelectedCategory").getJSONObject("vx:SelectedCabin");
		return cabin.get("CabinNumber").toString();
	 }
	 
	 public String getStatusBooking() {
		 JSONObject status =read.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:ReservationID");
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
	 
	 public String getAmountBooking (String amountValue) {
		 JSONArray amount =read.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:PaymentsDue").getJSONArray("vx:PaymentDue");
			int index=amount.length()-2;
			String  TotalAmount = null;
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
	 
	 public String getAmountMultiplePaymentsBooking() {
		 JSONArray amount =read.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:PaymentOptions").getJSONArray("vx:PaymentOption");
			int index=amount.length();
			double somma=0;

		     for(int i=0 ; i<index ; i++) {
		    	 JSONObject stringAmount=(JSONObject) amount.get(i);
		    	 double sum = Double.parseDouble(stringAmount.getJSONObject("vx:PaymentAmount").get("Amount").toString());
		    	 somma=somma + sum;
		     
		     }
		     
		     String value =String.valueOf((int)somma);
		     return value;

	 }
	 
	 public String getAmountSinglePaymentsBooking() {
		 JSONObject amount =read.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:PaymentOptions").getJSONObject("vx:PaymentOption").getJSONObject("vx:PaymentAmount");
			String value =amount.get("Amount").toString();
			
			
		     return value;
	 }
	 
	 public String getCabinCategory() {
		 JSONObject cabin =read.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:SailingInfo").getJSONObject("vx:SelectedCategory").getJSONObject("vx:SelectedCabin");
			return cabin.get("CabinCategoryCode").toString();
	 }
	 
	 public ArrayList <String>  get1AdultData(){
	        ArrayList <String> paxdata = new ArrayList <String>();

		    JSONObject Name =read.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:GuestDetails").getJSONObject("vx:GuestDetail").getJSONObject("vx:ContactInfo").getJSONObject("vx:PersonName");
			paxdata.add(Name.get("vx:GivenName").toString().toLowerCase());
			paxdata.add(Name.get("vx:Surname").toString().toLowerCase());
			JSONObject contact =read.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:GuestDetails").getJSONObject("vx:GuestDetail").getJSONObject("vx:ContactInfo");
			paxdata.add(contact.get("PersonBirthDate").toString());
			
			paxdata.add(contact.get("vx:Email").toString());
			return paxdata;
	 }
	 public ArrayList <String>  getAllPaxData(){
		 JSONArray data =read.getJSONObject("vx:OTA_ResRetrieveRS").getJSONObject("vx:ReservationsList").getJSONObject("vx:CruiseReservation").getJSONObject("vx:ReservationInfo").getJSONObject("vx:GuestDetails").getJSONArray("vx:GuestDetail");
			int index=data.length();
	        ArrayList <String> paxdata = new ArrayList <String>();

			for(int i=0 ; i<index ; i++) {
		    	 JSONObject dati=(JSONObject) data.get(i);
		    	paxdata.add(dati.getJSONObject("vx:ContactInfo").getJSONObject("vx:PersonName").get("vx:GivenName").toString().toLowerCase());
		    	paxdata.add(dati.getJSONObject("vx:ContactInfo").getJSONObject("vx:PersonName").get("vx:Surname").toString().toLowerCase()); 
		    	paxdata.add(dati.getJSONObject("vx:ContactInfo").get("PersonBirthDate").toString()); 
		    	if(Integer.parseInt(dati.getJSONObject("vx:ContactInfo").get("Age").toString())>17) {
		    		paxdata.add(dati.getJSONObject("vx:ContactInfo").get("vx:Email").toString());
		    	}
		        
		     }
			return paxdata;
	 }
}
