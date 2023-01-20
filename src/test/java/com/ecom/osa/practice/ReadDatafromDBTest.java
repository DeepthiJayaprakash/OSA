package com.ecom.osa.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDatafromDBTest {

	public static void main(String[] args) throws Throwable {
		
		Connection con = null;
		try {
		Driver driver=new Driver();
		//Step1:register the database
		DriverManager.registerDriver(driver);
		
		//Step2:Get connection for the database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root", "root");
		
		//step3: issue create statement
		 Statement state = con.createStatement();
		 String query = "select * from studentInfo;";
		
		//Step4:Execute query
		 ResultSet result = state.executeQuery(query);
		 
		 while(result.next())
		 {
			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		 }
		}
		catch(Exception e)
		{
			
		}
	
	finally
	{
		
		//Step5:Close the database
		con.close();
		System.out.println("Connection to the database is closed");

	}

	}
}
