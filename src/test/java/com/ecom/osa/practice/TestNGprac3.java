package com.ecom.osa.practice;

import org.testng.annotations.Test;

public class TestNGprac3 {


	@Test(groups = {"smoke","regression"})
	public void script5()
	{
		System.out.println("this is scrip5");
	}

	@Test(groups = {"smoke"})
	public void script6()
	{
		System.out.println("this is scrip6");
	}
}
