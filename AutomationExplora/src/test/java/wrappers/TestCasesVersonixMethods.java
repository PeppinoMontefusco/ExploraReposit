package wrappers;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;

import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.API;
import globalSetup.ExternalFunction;
import globalSetup.ReadResponse;
import globalSetup.setupDriver;

public class TestCasesVersonixMethods extends setupDriver {
	
	  

	public static ArrayList<String> addAdult(int i) throws InterruptedException {
		ArrayList<String> dati=new ArrayList<String>();
		
		for(int e=0;e<i;e++) {
		Report.passStep("Insert data Adult "+(e+1)+""); 
		String FirstName ="automation"+ExternalFunction.getRandomString(5);
		dati.add(FirstName);
	    VersonixMethodsB2C.searchInputAndCompile("First",FirstName);
	    Report.passStep("Adult "+(e+1)+" - Insert First Name");
		String LastName ="automation"+ExternalFunction.getRandomString(5);
		dati.add(LastName);
		VersonixMethodsB2C.searchInputAndCompile("Last",LastName);
		Report.passStep("Adult "+(e+1)+" - Insert Last Name");
		VersonixMethodsB2C.searchInputAndCompile("Date", "01011990");
		dati.add("1990-01-01");
		Report.passStep("Adult "+(e+1)+" - Insert Date Of Birth");
		String Email=FirstName+"@yopmail.com";
		dati.add(Email);
		VersonixMethodsB2C.searchInputAndCompile("Email", Email);
		Report.passStep("Adult "+(e+1)+" - Insert Email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		empdata.add(new Object[] { ApachePoiStyles.RESULTS,FirstName ,LastName , Email , "1990-01-01"} );
		
		Thread.sleep(1000);
		}
		return dati;
	}

	public static ArrayList<String> addChild(int i) throws InterruptedException {
		ArrayList<String> dati=new ArrayList<String>();
		
		for(int e=0;e<i;e++) {
		Report.passStep("Insert data Child "+(e+1)+"");
		String FirstName ="automation"+ExternalFunction.getRandomString(5);
		dati.add(FirstName);
	    VersonixMethodsB2C.searchInputAndCompile("First",FirstName);
	    Report.passStep("Child "+(e+1)+" - Insert First Name");
		String LastName ="automation"+ExternalFunction.getRandomString(5);
		dati.add(LastName);
		VersonixMethodsB2C.searchInputAndCompile("Last",LastName);
		Report.passStep("Child "+(e+1)+" - Insert Last Name");
		VersonixMethodsB2C.searchInputAndCompile("Date", "01012015");
		dati.add("2015-01-01");
		Report.passStep("Child "+(e+1)+" - Insert Date Of Birth");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		empdata.add(new Object[] { ApachePoiStyles.RESULTS,FirstName ,LastName , "" , "2015-01-01"} );
		Thread.sleep(1000);
		}
		return dati;
	}

	public static ArrayList<String> addInfant(int i) throws InterruptedException {
		ArrayList<String> dati=new ArrayList<String>();
		
		for(int e=0;e<i;e++) {
		Report.passStep("Insert data Infant "+(e+1)+"");
		String FirstName ="automation"+ExternalFunction.getRandomString(5);
		dati.add(FirstName);
	    VersonixMethodsB2C.searchInputAndCompile("First",FirstName);
	    Report.passStep("Infant "+(e+1)+" - Insert First Name");
		String LastName ="automation"+ExternalFunction.getRandomString(5);
		dati.add(LastName);
		VersonixMethodsB2C.searchInputAndCompile("Last",LastName);
		Report.passStep("Infant "+(e+1)+" - Insert Last Name");
		VersonixMethodsB2C.searchInputAndCompile("Date", "01012022");
		dati.add("2022-01-01");
		Report.passStep("Infant "+(e+1)+" - Insert Date Of Birth");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		empdata.add(new Object[] { ApachePoiStyles.RESULTS,FirstName ,LastName , "" , "2022-01-01"} );
		Thread.sleep(1000);
		}
		return dati;
	}

	public static ArrayList <String> loggedPaxData(){
		ArrayList <String> a = new ArrayList <String>();
		a.add("peppe");
		a.add("monte");
		a.add("1970-01-01");
		a.add("testnexsoftita@yopmail.com");
		empdata.add(new Object[] { ApachePoiStyles.RESULTS,"Peppe" ,"Monte" , "testnexsoftita@yopmail.com" , "1942-01-01"} );
		return a;
		
	}

	public static void confirmPopup(String a) throws InterruptedException {
		VersonixMethodsB2C.findSpanAndClick(a);
		Report.passStep("Click On Option 72h");
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('[style*=\"width: 32px; height: 32px\"]')[0].click();");
		
		Report.passStep("Click On First Privacy Checkbox");
		Thread.sleep(500);
		js.executeScript("return document.querySelector('flt-glass-pane').shadowRoot.querySelectorAll('[style*=\"width: 32px; height: 32px\"]')[1].click();");
		
		Report.passStep("Click On Second Privacy Checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.passStep("Click On Apply");
		WebWrapper.waitForJavascript();
	}

	public static String checkCabinStatusAmount() throws InterruptedException, UnirestException {
		String reservationInfo=VersonixMethodsB2C.getSummaryInformation("Booking");
		String invoiceInfo=VersonixMethodsB2C.getSummaryInformation("Invoice").replace(",","");
		String bookingNumber =reservationInfo.substring(10, 14);
		ReadResponse response =API.getReadResponse(bookingNumber);
		WebWrapper.verifyValue(reservationInfo, response.getCabinNumber(), "Cabin number");
		WebWrapper.verifyValue(reservationInfo, response.getStatusBooking(), "Status");
		WebWrapper.verifyValue(invoiceInfo, response.getAmountBooking("80"), "Amount Total");
		WebWrapper.verifyValue(invoiceInfo, response.getAmountBooking("70"), "Amount Due");
		return bookingNumber;
	}
	

}
