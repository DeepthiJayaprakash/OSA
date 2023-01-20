package com.ecom.osa.practice;

import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertpraacticeTest {
     
	
	@Test
	 public void test1()
	 {
		System.out.println("statement 1");
		System.out.println("statement 1");
		assertEquals("a", "b");
		System.out.println("statement 1");		
		System.out.println("statement 1");

	}
	
	@Test
	public void tset2()
	{
		System.out.println("statmnt 1");
		System.out.println("statmnt 2");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals("a", "b");
		System.out.println("statmnt 4");
		sa.assertAll();
		System.out.println("statmnt 5");
		
	}
	
	
	@Test
	public void test3()
	{
		String s1="";
		String s2=null;
		assertEquals(s1, s2, "this is for validation");
		SoftAssert sa1 = new SoftAssert();
		sa1.assertAll();
		System.out.println("statement 6");
		System.out.println("statmnt 77");
		
	}
	

}
