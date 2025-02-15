package scenario1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.AfterTest;

public class ExcelReader {
	String fPath = System.getProperty("user.dir") + "\\testdata\\userDetail.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	@Test (enabled = false)
	public void readData() {
		row = sheet.getRow(0);
		cell = row.getCell(0);
		
		System.out.println(cell.getStringCellValue());
		
		System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
		System.out.println(sheet.getRow(0).getCell(2).getStringCellValue());
	}
	
	
	@Test
	public void readAllData()
	{
		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
				
		for(int i = 0; i < totalRows; i++)
		{
			row = sheet.getRow(i);
			for(int j = 0; j < totalCells; j++)
			{
				cell = row.getCell(j);
				System.out.print("\t" + cell.getStringCellValue());
			}
			System.out.println();
		}
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("userData");		
	}
	
	@AfterTest
	public void afterTest() throws IOException {
		wb.close();
		fis.close();
	}
}