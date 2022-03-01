package globalSetup.b2c;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;




public class setupDriver {
	public static WebDriver driver;
	
	public static ExtentTest test;
	static {
		System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\WebDriver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
	
	
}
}