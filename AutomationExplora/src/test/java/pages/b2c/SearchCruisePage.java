package pages.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import globalSetup.b2c.setupDriver;

public class SearchCruisePage extends setupDriver {
	
	
	public static WebElement getFirstBookButton() {
		return driver.findElement(By.xpath("/html/body/flt-glass-pane//flt-scene-host/flt-scene/flt-transform/flt-clip/flt-clip-interior/flt-offset/flt-offset/flt-clip/flt-clip-interior/flt-clip[1]/flt-clip-interior/flt-offset/flt-offset/flt-offset/flt-offset/flt-offset/flt-clip/flt-clip-interior/flt-offset[1]/flt-offset/flt-clip[4]/flt-clip-interior/flt-picture/flt-canvas/canvas"));
		}
    
}
