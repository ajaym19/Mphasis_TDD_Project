package com.mphasis.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelReader(String excelPath, String sheetName)  {
		try {
			workbook = new XSSFWorkbook(excelPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
	}
	
	public int getRowCount() {
		int rowCount =0;
		rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
	
	public int getColCount() {
		return sheet.getRow(0).getLastCellNum();
	}
	
	public String getCellData(int rowNum, int colNum) {
		return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	
	
	public Object[][] getData() {
		int rowCount = getRowCount();
		int colCount = getColCount();		
		Object[][] data = new Object[rowCount-1][colCount];
		for (int row = 1; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row-1][col] = getCellData(row, col);
			}
		}
		return data;
	}
	
	
//	public static void main(String[] args) throws IOException {
//		ExcelReader reader = new ExcelReader();
//		int rowCount = sheet.getPhysicalNumberOfRows();
//		int colCount = sheet.getRow(0).getLastCellNum();
//		System.out.println(rowCount);
//		System.out.println(colCount);
//		
//		
//		//System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
//		//System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
//		//System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
//		//System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
//		
//		for (int row = 0; row < rowCount; row++) {
//			for (int col = 0; col < colCount; col++) {
//				String celldata = sheet.getRow(row).getCell(col).getStringCellValue();
//				System.out.println(celldata);
//			}
//		}
//		
//	}
	
	
}
