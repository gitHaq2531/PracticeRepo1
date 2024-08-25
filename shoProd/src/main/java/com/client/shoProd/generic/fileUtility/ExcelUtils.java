package com.client.shoProd.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils 
{
	public FileInputStream fisExcel;
	public Workbook workbook;
	public Sheet sheet;
	
	public ExcelUtils(String sheetname) throws Exception{
		fisExcel= new FileInputStream("src/test/resources/shoProdTestData.xlsx");
		workbook = WorkbookFactory.create(fisExcel);
		sheet = workbook.getSheet(sheetname);
	}
	
	public String getDataFromExcel(int rownum,int cellnum) throws Exception{
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String data=cell.getStringCellValue();
		workbook.close();
		return data;
	}
	
	//to write data back to excel...
	
	@SuppressWarnings("deprecation")
	public void writeDataInExcel(int rownum,int cellnum,String value) throws Exception{
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(value);
		FileOutputStream fos=new FileOutputStream("src/test/resources/shoProd.xlsx");
		workbook.write(fos);
		workbook.close();
	}
	
	// to get row count...
	public int getRowCount() throws Exception{
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		return rowCount;
	}
	
	// to get cell count... 
	public int getCellCount(int rowIndex) throws Exception{
		Row row = sheet.getRow(rowIndex);
		int cellCount=row.getLastCellNum();
		workbook.close();
		return cellCount;
	}
}