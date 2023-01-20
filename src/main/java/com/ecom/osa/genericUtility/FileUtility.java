package com.ecom.osa.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getPropertyKeyvalue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.Filepath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
		
	}
}
