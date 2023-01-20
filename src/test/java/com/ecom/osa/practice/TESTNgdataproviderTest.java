package com.ecom.osa.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecom.osa.genericUtility.ExcelUtility;

public class TESTNgdataproviderTest {

	
	@Test(dataProvider="getData")
	 public void readdata(String firstname,String lastname)
	 
	 {
		System.out.println(firstname+"------>"+lastname);
	 }



@DataProvider
public Object[][] getData() throws Throwable
{
	ExcelUtility elib=new ExcelUtility();
	Object [][] value= elib.readmultiplesetofdatatestng("ProductTestdata");
	return value;
}
}