package com.ecom.osa.practice;

import org.testng.annotations.Test;

public class TestNGprac2 {

	

	@Test(groups = {"regression"})
	public void script3()
	{
		System.out.println("this is scrip3");
	}

	@Test(groups = {"smoke"})
	public void script4()
	{
		System.out.println("this is scrip4");
	}
}
