package globalSetup;

import java.util.ResourceBundle;

public class Configuration {
	String URL;
	String URLProd;
	String Username;
	String Password;
	String EmailRecovery;
	String CardNumber;
	String ExpireDate;
	String Cvv;
	String Name;
	String NameProd;
	String CardNumber3DS1;
	String Username3DS1;
	String Password3DS1;
	String CardNumber3DS2;
	String UsernameB2B;
	String PasswordB2B;
	String URLB2B;
	String UsernameProd;
	String PasswordProd;
	String EmailRecoveryProd;
	String UsernameB2BProd;
	String PasswordB2BProd;

	public String URLGeneric;
	public String URLGenericProd;

	public Configuration() {
		ResourceBundle configuration = ResourceBundle.getBundle("configurations");
		URL = configuration.getString("URL");
		URLProd = configuration.getString("URLProd");
		Username = configuration.getString("Username");
		Password = configuration.getString("Password");
		EmailRecovery = configuration.getString("EmailRecovery");
		CardNumber = configuration.getString("CardNumber");
		ExpireDate = configuration.getString("ExpireDate");
		Cvv = configuration.getString("Cvv");
		Name = configuration.getString("Name");
		NameProd = configuration.getString("NameProd");
		CardNumber3DS1 = configuration.getString("CardNumber3DS1");
		Username3DS1 = configuration.getString("Username3DS1");
		Password3DS1 = configuration.getString("Password3DS1");
		CardNumber3DS2 = configuration.getString("CardNumber3DS2");
		URLGeneric = configuration.getString("URLGeneric");
		URLGenericProd = configuration.getString("URLGenericProd");
		UsernameB2B = configuration.getString("UsernameB2B");
		PasswordB2B = configuration.getString("PasswordB2B");
		URLB2B = configuration.getString("URLB2B");
		UsernameProd = configuration.getString("UsernameProd");
		PasswordProd = configuration.getString("PasswordProd");
		EmailRecoveryProd= configuration.getString("EmailRecoveryProd");
		UsernameB2BProd= configuration.getString("UsernameB2BProd");
		PasswordB2BProd= configuration.getString("PasswordB2BProd");
	}

	public String getUsernameB2BProd() {
		return UsernameB2BProd;
	}

	public String getPasswordB2BProd() {
		return PasswordB2BProd;
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
	public String nameProd() {
		return NameProd;
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
	public String getUrlGenericProd() {
		return URLGenericProd;
	}

	public String getUrlProd() {
		return URLProd;
	}

	public String usernameB2B() {
		return UsernameB2B;
	}

	public String passwordB2B() {
		return PasswordB2B;
	}
	public String getUrlB2B() {
		return URLB2B;
	}
	public String usernameProd() {
		return UsernameProd;
	}

	public String passwordProd() {
		return PasswordProd;
	}
	public String emailRecoveryProd() {
		return EmailRecoveryProd;
	}
}
