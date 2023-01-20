package com.ecom.osa.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testngdataprovider {

	
	@Test(dataProvider="data")
	
	public void travel(String src,String dst)
	{
		System.out.println("from   "+src+"------>"+"to  "+dst);
		
	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] objarr=new Object[2][2];
		objarr[0][0]="bengaluru";
		objarr[0][1]="tumkuru";
		
		objarr[1][0]="kodaikanal";
		objarr[1][1]="ooty";
		return objarr;
	}
	
}
