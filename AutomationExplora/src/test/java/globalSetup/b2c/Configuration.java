package globalSetup.b2c;

import java.util.ResourceBundle;

public class Configuration {
	String URL;
	String Username;
	
	public Configuration(){
		ResourceBundle configuration= ResourceBundle.getBundle("configurations");
		URL = configuration.getString("URL");
		Username = configuration.getString("Username");
		
	}

}
