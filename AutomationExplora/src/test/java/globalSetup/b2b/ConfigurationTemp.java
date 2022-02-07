package globalSetup.b2b;

import java.util.ResourceBundle;

public class ConfigurationTemp {
	String URL;
	String Username;
	String Password;
	
	public ConfigurationTemp(){
		ResourceBundle configuration= ResourceBundle.getBundle("configurations");
		URL = configuration.getString("URL");
		Username = configuration.getString("Username");
		Password = configuration.getString("Password");
		
	}

}

