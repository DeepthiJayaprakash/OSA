package com.ecom.osa.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class RmgTestingserverDBTest {

	public static void main(String[] args) throws Throwable {
		 Driver driver = new Driver();
    Connection con=null;
    int result=0;
   
    try {
    	
    	
    	//Step1:register the db
    	
    	DriverManager.registerDriver(driver);
    	
    	//Step2:get connection to the db
    	con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
    	//step3:Issue create statement
    	Statement state = con.createStatement();
    	
    	    String query = "insert into project values('TY_Project_20000','Deepthi','21/12/2022','QA45','in Progress',45);";
    	 //step4:Update query
    	    result=state.executeUpdate(query);
    	    //
    	      
    }
    catch(Exception e) {
    	
    }
finally {
	
	if(result==1)
	{
		System.out.println("DATA is inserted successfully");
		
	}
	else
	{
		System.out.println("data not inserted");
		
	}
	//step5 :close the db connection
	con.close();
}
	}

}
