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

}

