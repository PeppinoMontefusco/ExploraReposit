package wrappers;

import globalSetup.setupDriver;

public class ApachePoiMethods extends setupDriver {
	
	
	public static void writeBookingNumberInExcel(String bookingNumber) {
		empdata.add(new Object[] { ApachePoiStyles.BOOKINGNUMBER,"" ,"" , "" , "", "Booking number: "+bookingNumber} );
		empdata.add(new Object[] { ApachePoiStyles.EMPTYROW} );
		empdata.add(new Object[] { ApachePoiStyles.EMPTYROW} );
	}
	
    public static void writeCell (String cell) {
    	empdata.add(new Object[] {ApachePoiStyles.TESTNAME , cell} );
    	empdata.add(new Object[] {ApachePoiStyles.EMPTYROW ,"" ,"" , "" , ""} );
    }

}
