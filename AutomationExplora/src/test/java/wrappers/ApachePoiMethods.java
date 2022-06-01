package wrappers;

import globalSetup.setupDriver;

public class ApachePoiMethods extends setupDriver {
	
	
	public static void writeBookingNumberInExcel(String bookingNumber) {
		empdata.add(new Object[] { "" ,"" , "" , "", "Booking number: "+bookingNumber} );
		empdata.add(new Object[] { } );
		empdata.add(new Object[] { } );
	}
	
    public static void writeCell (String cell) {
    	empdata.add(new Object[] { cell} );
    	empdata.add(new Object[] { } );
    }

}
