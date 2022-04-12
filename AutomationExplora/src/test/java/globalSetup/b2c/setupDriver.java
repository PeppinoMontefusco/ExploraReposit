package globalSetup.b2c;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;




public class setupDriver {
	public static WebDriver driver;
	
	public static ExtentTest test;
	/*static {
		System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\WebDriver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
	
	
}*/
	
	@BeforeMethod 
	public void before_method()  
	{  
        System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\WebDriver\\chromedriver.exe");
        
        //ChromeOptions  options = new ChromeOptions();
        
        
        //options.addExtensions(new File("C:\\Users\\WebDriver\\ModHeader.crx"));
        
        driver=new ChromeDriver();
        /*driver.get("https://chrome.google.com/webstore/detail/modheader/idgpnmonknjnojddfkpgkljpfnnfcklj?hl=it");
		
		
		
		((JavascriptExecutor)driver).executeScript(
			    "localStorage.setItem('profiles', JSON.stringify([{                " +
			    "  title: 'Selenium', hideComment: true, appendMode: '',           " +
			    "  headers: [                                                      " +
			    "    {enabled: true, name: 'x-restricted-custom', value: 'SQEB3yich9rhog-maiy', comment: ''} " +
			    "  ],                                                              " +
			    "  respHeaders: [],                                                " +
			    "  filters: []                                                     " +
			    "}]));                                                             " );*/

		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS); 
	}  
	
	@AfterMethod
	public void after_method()  
	{  
	driver.quit(); 
	}  
}