package globalSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentTest;

import wrappers.ApachePoiStyles;
import wrappers.ExcelName;
import wrappers.OutputLine;


public class setupDriver {
	public static WebDriver driver;

	public static ExtentTest test;
	public static XSSFWorkbook workbook;
	public static ArrayList<OutputLine> empdata = new ArrayList<OutputLine>();
	public static XSSFSheet sheet;

	@BeforeSuite
	public void before_suite() throws IOException {

		System.setProperty("org.apache.poi.util.POILogger", "org.apache.commons.logging.impl.NoOpLog");

		
        
		empdata.add(new OutputLine ( ApachePoiStyles.HEADER,List.of("FirstName", "LastName", "Email", "Date Of Birth"),ExcelName.BOOKING));
		empdata.add(new OutputLine ( ApachePoiStyles.HEADER,ExcelName.BOOKING));
		empdata.add(new OutputLine ( ApachePoiStyles.HEADER,List.of("Username", "Password"),ExcelName.USERS));
		empdata.add(new OutputLine ( ApachePoiStyles.HEADER,ExcelName.USERS));
	}
		
	
	@AfterSuite
	public void after_suite() throws IOException {

	
		writeExcel(ExcelName.BOOKING);
		writeExcel(ExcelName.USERS);
	}

	private void writeExcel(ExcelName excel) throws IOException {
		
		FileInputStream inputStream = new FileInputStream(new File(".\\Results\\" +excel.path));
		workbook = new XSSFWorkbook(inputStream);
		inputStream.close();

		LocalDateTime today = LocalDateTime.now();
		String formattedDate = today.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)).replace(":",
				".");
		sheet = workbook.createSheet(formattedDate);
		sheet.setColumnWidth(0, 35 * 256);
		sheet.setColumnWidth(1, 25 * 256);
		sheet.setColumnWidth(2, 35 * 256);
		sheet.setColumnWidth(3, 25 * 256);
		sheet.setColumnWidth(4, 25 * 256);
		
		
		var rows = empdata.stream().filter(x->x.getPath().equals(excel)).collect(Collectors.toList());
		int rowCount = 0;
		for (OutputLine emp : rows) {
			
            
			XSSFRow row = setupDriver.sheet.createRow(rowCount++);
			int columnCount = 0;
			for (int i=0; i<emp.getValues().size();i++){
				String value=emp.getValues().get(i);
				XSSFCell cell = row.createCell(columnCount++);
				cell.setCellValue(value);
				cell.setCellStyle((emp.getStyle().getCellStyle(value)));
			}

		}
		
		FileOutputStream automation = new FileOutputStream(".\\Results\\" +excel.path);
		workbook.write(automation);
		automation.flush();
		automation.close();
	}
	
	
	@BeforeMethod
	public void before_method() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\WebDriver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void after_method() {

		//driver.quit();

	}
}