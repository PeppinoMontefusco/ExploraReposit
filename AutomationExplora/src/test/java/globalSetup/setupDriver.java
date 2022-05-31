package globalSetup;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public static XSSFWorkbook workbook;
	public static ArrayList <Object[]> empdata= new ArrayList<Object[]>();
	public static XSSFSheet sheet;
	
	@BeforeSuite
	public void before_suite() throws IOException {
		
		System.setProperty("org.apache.poi.util.POILogger","org.apache.commons.logging.impl.NoOpLog");
		
        FileInputStream inputStream = new FileInputStream(new File(".\\Results\\auomation.xlsx"));
         workbook = new XSSFWorkbook(inputStream);
         inputStream.close();
		
		LocalDateTime today = LocalDateTime.now();
		String formattedDate = today.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)).replace(":",".");
		sheet=workbook.createSheet(formattedDate);
		sheet.setColumnWidth(0, 25 * 256);
		sheet.setColumnWidth(1, 25 * 256);
		sheet.setColumnWidth(2, 35 * 256);
		sheet.setColumnWidth(3, 25 * 256);
		sheet.setColumnWidth(4, 25 * 256);
		
		
		empdata.add(new Object[] {"FirstName" , "LastName" , "Email" , "Date Of Birth"} );
		
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.index);
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle.setBorderTop(BorderStyle.MEDIUM);
		cellStyle.setBorderBottom(BorderStyle.MEDIUM);
		cellStyle.setBorderLeft(BorderStyle.MEDIUM);
		cellStyle.setBorderRight(BorderStyle.MEDIUM);
		XSSFFont font = workbook.createFont();
		font.setFontName("Asana");
		font.setColor(IndexedColors.WHITE.index);
		font.setBold(true);
		cellStyle.setFont(font);
		
		
		for (Object[] emp:empdata) {
			XSSFRow row=setupDriver.sheet.createRow(0);
			int columnCount=0;
			for(Object value:emp) {
				XSSFCell cell=row.createCell(columnCount++);
				cell.setCellValue((String)value);
				cell.setCellStyle(cellStyle);
			
				
			}}
	empdata.clear();
	}
	
    @AfterSuite
    public void after_suite() throws IOException {
    	CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setBorderTop(BorderStyle.MEDIUM);
		cellStyle.setBorderBottom(BorderStyle.MEDIUM);
		cellStyle.setBorderLeft(BorderStyle.MEDIUM);
		cellStyle.setBorderRight(BorderStyle.MEDIUM);
		XSSFFont font = workbook.createFont();
		font.setFontName("Asana");
		font.setBold(true);
		cellStyle.setFont(font);
    	int rowCount=1;
		for (Object[] emp:empdata) {
			XSSFRow row=setupDriver.sheet.createRow(rowCount++);
			int columnCount=0;
			for(Object value:emp) {
				XSSFCell cell=row.createCell(columnCount++);
				cell.setCellValue((String)value);
				cell.setCellStyle(cellStyle);
			
				
		}
		
	}
		
		String filepath=".\\Results\\auomation.xlsx";
		FileOutputStream automation=new FileOutputStream(filepath);
		setupDriver.workbook.write(automation);
		automation.flush();
		automation.close();
    }
    
	
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
	    
       driver.quit(); 
		
	
	}  
}