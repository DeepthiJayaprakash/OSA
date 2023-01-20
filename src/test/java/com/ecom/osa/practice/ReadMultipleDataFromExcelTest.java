package com.ecom.osa.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws Exception {
FileInputStream fis = new FileInputStream("./src/test/resources/Testdata45.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		    int totalcount = sh.getLastRowNum();
		    
		    for(int i=0;i<=totalcount;i++)
		    {
		    	Row row = sh.getRow(i);
		    	for(int j=0;j<row.getLastCellNum();j++)
		    		{
		    			String sheetdata = row.getCell(j).getStringCellValue();
		    
		    			System.out.print(sheetdata+"  ");
		    		}
		    	System.out.println();
		    }
	}

}
