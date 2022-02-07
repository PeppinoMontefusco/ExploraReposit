package globalSetup.b2c;

import java.util.ResourceBundle;

public class Configuration {
	String URL;
    String Username;
	String Password;
	
	public Configuration(){
		ResourceBundle configuration= ResourceBundle.getBundle("configurations");
		URL = configuration.getString("URL");
		Username = configuration.getString("Username");
		Password = configuration.getString("Password");
		
	}
	
	public String username() {
		return Username;
	}
	
	public String password() {
		return Password;
	}

}

