package globalSetup.b2c;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



public class setupDriver {
	public static WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\WebDriver\\chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		Map<String,Object> screen =new HashMap();
		screen.put("width", 800);
		screen.put("height", 1200);
		screen.put("pixelRatio", 1);
		Map<String,Object> device =new HashMap();
		device.put("deviceMetrics", screen);
		options.setExperimentalOption("mobileEmulation", device);
		driver=new ChromeDriver(options);
		
		//System.setProperty("webdriver.gecko.driver" ,"C:\\Users\\WebDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
	
	
}
}