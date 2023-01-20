package com.ecom.osa.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			
			FileInputStream fis = new FileInputStream("./src/test/resources/Testdata45.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			
			Sheet sh = wb.getSheet("Sheet1");
			Row row = sh.createRow(3);
			    Cell cell = row.createCell(3);
			    cell.setCellValue("Fireflink");
			      //String SheetName = sh.getRow(1).getCell(0).getStringCellValue();
			      FileOutputStream fos = new FileOutputStream("./src/test/resources/Testdata45.xlsx");
			      wb.write(fos);
			      
			
			
		}

}
