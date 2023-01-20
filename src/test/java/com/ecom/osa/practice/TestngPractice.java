package com.ecom.osa.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngPractice {
@Test(priority=0,invocationCount=1)
	public void createCategory()
	{
		System.out.println("category created");
	}
@Test(priority = 1, invocationCount = 2 ,dependsOnMethods ="createCategory")
public void createSubcategory()
{
 System.out.println("Subcategory Created");
}
@Test(priority = 2, invocationCount = 4, dependsOnMethods ={"createCategory", "createSubcategory"}, dataProvider = "data")
public void insertProduct(String pn, String br, String pr)
{
 System.out.println("Product is inserted and its "+pn+" of "+br+" with "+pr);
}
@Test(priority = 3, invocationCount = 3,dependsOnMethods ="insertProduct" )
public void manageProduct()
{
 System.out.println("Produt details is edited");
}
@Test(priority = 4, invocationCount = 2,dependsOnMethods ="insertProduct" )
public void purchaseProduct()
{
 System.out.println("Product is been purchased");
}
@Test(priority = 5, invocationCount = 1,dependsOnMethods ="purchaseProduct" )
public void manageOrder()
{
 System.out.println("Purchase has been managed");
 
}
@DataProvider
public Object[][] data()
{
 Object[][] obarr = new Object[3][3];
 obarr[0][0]= "Mobile";
 obarr[0][1]= "brand";
 obarr[0][2]= "price";
 obarr[1][0]= "Mobile1";
 obarr[1][1]= "brand1";
 obarr[1][2]= "price1";
 obarr[2][0]= "Mobile2";
 obarr[2][1]= "brand2";
 obarr[2][2]= "price2";
 return obarr;
}
}













