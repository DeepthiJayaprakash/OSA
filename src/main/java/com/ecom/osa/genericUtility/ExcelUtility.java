package com.ecom.osa.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility extends JavaUtility {

	public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/OSA_TestCommonData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		String data = row.getCell(cellnum).getStringCellValue();
		wb.close();
		return data;
	}
	


public void writeDataIntoExcel(String sheetname,int rownum,int cellnum,String data) throws Throwable
{
	FileInputStream fis = new FileInputStream("./src/test/resources/OSA_TestCommonData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	Row ro = sh.createRow(rownum);
	Cell cel = ro.createCell(cellnum);
	cel.setCellValue(data);
	FileOutputStream fos = new FileOutputStream("./src/test/resources/OSA_TestCommonData.xlsx");
	wb.write(fos);
}

public int getLastRowNo(String sheetname) throws Throwable
{
	
	FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	int count = sh.getLastRowNum();
	return count;
	
}


public HashMap<String , String> getList(String sheetname,int keycell, int valuecell) throws Throwable
{
	FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	int count = sh.getLastRowNum();
	HashMap<String,String> map = new HashMap<String,String>();
	for(int i=0;i<=count;i++)
	{
		String key=sh.getRow(i).getCell(keycell).getStringCellValue();
		String value=sh.getRow(i).getCell(valuecell).toString();
		map.put(key, value);
	}
	return map;
	
	
}


public Object[][] readmultiplesetofdatatestng(String Sheetname) throws Throwable
{
	FileInputStream fi=new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fi);
	     Sheet sh = wb.getSheet(Sheetname);
	     int lastRow = sh.getLastRowNum()+1;
	     int lastCell = sh.getRow(0).getLastCellNum();
	     
	     Object[][] obj = new Object[lastRow][lastCell];
	     for(int i=0;i<lastRow;i++)
	     {
	     
	    	 for(int j=0;j<lastCell;j++)
	    	 {
	    		 obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	    	 }
	    	 
	     }
		return obj;
}
	     
}	     
	     
	     
	     
	     
	     
	
