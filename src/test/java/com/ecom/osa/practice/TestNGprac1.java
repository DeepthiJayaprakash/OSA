package com.ecom.osa.practice;

import org.testng.annotations.Test;

public class TestNGprac1 {

	
	@Test(groups = {"smoke"})
	public void script1()
	{
		System.out.println("this is scrip1");
	}

	@Test(groups = {"regression"})
	public void script2()
	{
		System.out.println("this is scrip2");
	}
}
