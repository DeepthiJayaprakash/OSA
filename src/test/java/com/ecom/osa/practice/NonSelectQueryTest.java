package com.ecom.osa.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws Throwable {

    Connection con=null;
    int result=0;
    try {
    	Driver driver = new Driver();
    	
    	//Step1:register the db
    	
    	DriverManager.registerDriver(driver);
    	
    	//Step2:get connection to the db
    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
    	//step3:Issue create statement
    	Statement state = con.createStatement();
    	
    	    String query = "insert into studentInfo values('Bhavana','btr','java',1);";
    	 //step4:Update query
    	    result=state.executeUpdate(query);
    	    
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
