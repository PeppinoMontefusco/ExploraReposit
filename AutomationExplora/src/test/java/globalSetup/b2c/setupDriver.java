package globalSetup.b2c;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;



public class setupDriver {
	public static WebDriver driver;
	static {
		//System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\WebDriver\\chromedriver.exe");
		//driver=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver" ,"C:\\Users\\WebDriver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
	
	
}
}