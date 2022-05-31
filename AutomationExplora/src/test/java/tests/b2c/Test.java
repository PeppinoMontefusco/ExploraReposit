package tests.b2c;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Locale;


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.API;
import globalSetup.startPage;
import wrappers.VersonixMethodsB2C;

public class Test extends VersonixMethodsB2C {

	public static void main(String[] args) throws IOException {
		
		
		XSSFWorkbook workbook= new XSSFWorkbook();
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
			System.out.println("SHORT format: " + formattedDate);
		XSSFSheet sheet=workbook.createSheet("Automation " + formattedDate);
		Object empdata[][] = {{"Firstname" , "Lastname"},
				{"Mario" , "Paolino"},
				{"Valentinsa" , "Villano"}
				
		   };
		CellStyle ciao= workbook.createCellStyle();
		
		int row =empdata.length;
		int col=empdata[0].length;
		
		for(int i=0 ; i<row ; i++) {
			XSSFRow rows =sheet.createRow(i);
			for(int j=0;j<col;j++) {
				XSSFCell cell= rows.createCell(j);
				cell.setCellValue((String)empdata[i][j]);			}
		}
		
		String filepath=".\\Results\\auomation.xlsx";
		FileOutputStream automation=new FileOutputStream(filepath);
		workbook.write(automation);
		automation.close();
	}

}
