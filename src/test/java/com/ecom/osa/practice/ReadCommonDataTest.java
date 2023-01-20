package com.ecom.osa.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.ecom.osa.genericUtility.FileUtility;

public class ReadCommonDataTest {

	public static void main(String[] args) throws Throwable {
		//Step1:get object representation for physical file
		
		//FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		
		//step2:crate object for properties
//		Properties pObj = new Properties();
//		
//		//step3:load the file
//		
//		pObj.load(fis);
//		
//		//step4:Read from file
//		    String adminUrl = pObj.getProperty("Aurl");
//		    String adminusername= pObj.getProperty("Ausername");
//		    String adminpassword= pObj.getProperty("Apassword");
//		    String Browser= pObj.getProperty("browser");
		    FileUtility flib=new  FileUtility();
		    String adminUrl= flib.getPropertyKeyvalue("Aurl");
		    String adminusername= flib.getPropertyKeyvalue("Ausername");
		    String adminpassword=flib.getPropertyKeyvalue("Apassword");
		    String Browser= flib.getPropertyKeyvalue("browser");
		    
		    
		    
		    
		    System.out.println("The data from properties file are "+adminUrl+" "+adminusername+" "+adminpassword+" "+Browser);
		    

	}

}
