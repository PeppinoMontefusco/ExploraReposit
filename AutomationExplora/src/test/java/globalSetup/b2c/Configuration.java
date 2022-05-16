package globalSetup.b2c;

import java.util.ResourceBundle;

public class Configuration {
	String URL;
    String Username;
	String Password;
	String EmailRecovery;
	String CardNumber;
	String ExpireDate;
	String Cvv;
	String Name;
	String CardNumber3DS1;
	String Username3DS1;
	String Password3DS1;
	String CardNumber3DS2;
	public String URLGeneric;
	
	
	public Configuration(){
		ResourceBundle configuration= ResourceBundle.getBundle("configurations");
		URL = configuration.getString("URL");
		Username = configuration.getString("Username");
		Password = configuration.getString("Password");
		EmailRecovery = configuration.getString("EmailRecovery");
		CardNumber = configuration.getString("CardNumber");
		ExpireDate = configuration.getString("ExpireDate");
		Cvv = configuration.getString("Cvv");
		Name= configuration.getString("Name");
		CardNumber3DS1= configuration.getString("CardNumber3DS1");
		Username3DS1= configuration.getString("Username3DS1");
		Password3DS1= configuration.getString("Password3DS1");
		CardNumber3DS2= configuration.getString("CardNumber3DS2");
		URLGeneric= configuration.getString("URLGeneric");
		
	}
	public String username() {
		return Username;
	}
	
	public String password() {
		return Password;
	}
	
	public String emailRecovery() {
		return EmailRecovery;
	}
	public String cardNumber() {
		return CardNumber;
	}
	
	public String expireDate() {
		return ExpireDate;
	}
	
	public String cvv() {
		return Cvv;
	}
	
	public String name() {
		return Name;
	}

	public String cardNumber3DS1() {
		return CardNumber3DS1;
	}
	public String username3DS1() {
		return Username3DS1;
	}
	public String password3DS1() {
		return Password3DS1;
	}
	public String cardNumber3DS2() {
		return CardNumber3DS2;
	}
	public String getUrlGeneric() {
		return URLGeneric;
	}
	
}

