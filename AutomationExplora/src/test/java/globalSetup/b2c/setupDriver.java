package globalSetup.b2c;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;




public class setupDriver {
	public static WebDriver driver;
	
	public static ExtentTest test;
	
	
	@BeforeMethod
	public void before_method() throws InterruptedException  
	{  
        System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\WebDriver\\chromedriver.exe");
        
        
        
        driver=new ChromeDriver();
       
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS); 
		
	}  
	
	@AfterMethod
	public void after_method()  
	{  
	    
    //driver.quit(); 
		
	
	}  
}