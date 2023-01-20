package com.ecom.osa.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNo()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
		
	}
	
	public String getSystemDate()
	{
		Date dt= new Date();
		String date = dt.toString();
		return date;
	}
	public String getSytemDateformat()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("DD-MM-YYYY hh-mm-ss");
		Date date = new Date();
		String systemdateandtime = dateformat.format(date);
		return systemdateandtime;
	}
}
