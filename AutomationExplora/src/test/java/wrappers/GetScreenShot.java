package wrappers;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;



public class GetScreenShot {
    
    public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir")+screenShotName+".png";
        File destination = new File(dest);
        Files.copy(source, destination);        
                     
        return dest;
    }
}