package globalSetup.b2c;

import java.util.ResourceBundle;

public class Configuration {
	String URL;
    String Username;
	String Password;
	String EmailRecovery;
	
	public Configuration(){
		ResourceBundle configuration= ResourceBundle.getBundle("configurations");
		URL = configuration.getString("URL");
		Username = configuration.getString("Username");
		Password = configuration.getString("Password");
		EmailRecovery = configuration.getString("EmailRecovery");
		
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

}

