package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 /**
 * 
 * @author Hemant
 *
 */
public class fileutility {
	/**
	 * use to get data from propertyfile based on key
	 * @param key
	 * @return the value of key in the form of string
	 * @throws Throwable
	 */
	public String getpropertykey(String key) throws Throwable {
	FileInputStream fis=new FileInputStream("./data/commonData.properties");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	}
	}
	
