package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class setupDriver {
	public static WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\utente\\Desktop\\eclipse-workspace\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
}
