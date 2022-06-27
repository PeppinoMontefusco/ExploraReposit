package wrappers;

import java.util.List;

import globalSetup.setupDriver;

public class ApachePoiMethods extends setupDriver {
	
	
	public static void writeBookingNumberInExcel(String bookingNumber) {
		empdata.add(new OutputLine ( ApachePoiStyles.BOOKINGNUMBER,List.of("" ,"" , "" , "", "Booking number: "+bookingNumber),ExcelName.BOOKING));
		empdata.add(new OutputLine ( ApachePoiStyles.EMPTYROW,ExcelName.BOOKING));
		empdata.add(new OutputLine ( ApachePoiStyles.EMPTYROW,ExcelName.BOOKING) );
	}
	
    public static void writeCell (String cell) {
    	empdata.add(new OutputLine (ApachePoiStyles.TESTNAME , List.of(cell),ExcelName.BOOKING) );
    	empdata.add(new OutputLine (ApachePoiStyles.EMPTYROW ,List.of("" ,"" , "" , ""),ExcelName.BOOKING) );
    }

}
