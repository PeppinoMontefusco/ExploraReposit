package wrappers;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFFont;

import globalSetup.setupDriver;

public enum ApachePoiStyles {

	HEADER {
		public CellStyle getCellStyle(String cell) {

			CellStyle cellStyle = setupDriver.workbook.createCellStyle();

			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.index);
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellStyle.setBorderTop(BorderStyle.MEDIUM);
			cellStyle.setBorderBottom(BorderStyle.MEDIUM);
			cellStyle.setBorderLeft(BorderStyle.MEDIUM);
			cellStyle.setBorderRight(BorderStyle.MEDIUM);
			XSSFFont font = setupDriver.workbook.createFont();
			font.setFontName("Asana");
			font.setColor(IndexedColors.WHITE.index);
			font.setBold(true);
			cellStyle.setFont(font);
			return cellStyle;
		}
	},
	TESTNAME {
		public CellStyle getCellStyle(String cell) {
			CellStyle cellStyle = setupDriver.workbook.createCellStyle();

			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setBorderTop(BorderStyle.MEDIUM);
			cellStyle.setBorderBottom(BorderStyle.MEDIUM);
			cellStyle.setBorderLeft(BorderStyle.MEDIUM);
			cellStyle.setBorderRight(BorderStyle.MEDIUM);
			XSSFFont font = setupDriver.workbook.createFont();
			font.setFontName("Asana");
			font.setColor(IndexedColors.RED.index);
			font.setBold(true);
			cellStyle.setFont(font);
			return cellStyle;
		}
	},

	RESULTS {
		public CellStyle getCellStyle(String cell) {
			CellStyle cellStyle = setupDriver.workbook.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setBorderTop(BorderStyle.MEDIUM);
			cellStyle.setBorderBottom(BorderStyle.MEDIUM);
			cellStyle.setBorderLeft(BorderStyle.MEDIUM);
			cellStyle.setBorderRight(BorderStyle.MEDIUM);
			XSSFFont font = setupDriver.workbook.createFont();
			font.setFontName("Asana");
			font.setBold(true);
			cellStyle.setFont(font);
			return cellStyle;
		}
	}

	,
	EMPTYROW {
		public CellStyle getCellStyle(String cell) {

			CellStyle cellStyle = setupDriver.workbook.createCellStyle();
			cellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			return cellStyle;
		}
	},
	BOOKINGNUMBER{
		public CellStyle getCellStyle(String cell) {
			CellStyle cellStyle = setupDriver.workbook.createCellStyle();
			if(cell.isEmpty()) {
				
				cellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			}
			else {
				cellStyle.setAlignment(HorizontalAlignment.CENTER);
				cellStyle.setBorderTop(BorderStyle.MEDIUM);
				cellStyle.setBorderBottom(BorderStyle.MEDIUM);
				cellStyle.setBorderLeft(BorderStyle.MEDIUM);
				cellStyle.setBorderRight(BorderStyle.MEDIUM);
				XSSFFont font = setupDriver.workbook.createFont();
				font.setFontName("Asana");
				font.setColor(IndexedColors.GREEN.index);
				font.setBold(true);
				cellStyle.setFont(font);
			}
			return cellStyle;
		}
		
	};

	public abstract CellStyle getCellStyle(String cell);

}	


