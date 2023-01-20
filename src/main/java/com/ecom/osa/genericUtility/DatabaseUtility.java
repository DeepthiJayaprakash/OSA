package com.ecom.osa.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;



public class DatabaseUtility {

	
	Connection con= null;
	  
	
	public void connectToDB() throws Throwable {
		
		Driver driver = new Driver ();
		DriverManager.registerDriver(driver);
		con= DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DBUSERNAME, IpathConstants.DBPASSWORD);
		
	}



public String executeQueryAndgetData(String query,int columnndex,String expdata) throws Throwable
{
	ResultSet result =con.createStatement().executeQuery(query);
	boolean flag = false;
	while(result.next())
	{
		 String data=result.getString(columnndex);
		 System.out.println(data);
		 if(data.equalsIgnoreCase(expdata))
		 {
			 flag=true;
			 break;
			 
		 }
	}
	if(flag)
	{
		System.out.println(expdata+"Project is created");
		return expdata;
	}
	else
	{
		System.out.println("Project is no created");
		return "";
		
	}
	
}

public void disconnectDB() throws Throwable
{
	con.close();
}
}

