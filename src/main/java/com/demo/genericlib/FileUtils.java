package com.demo.genericlib;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtils {

	public Properties getPropertiesObject() throws Throwable{
		
		FileInputStream fis =  new FileInputStream("/home/priya/Desktop/PomeloTask/src/test/resources/commonData.properties");
		Properties pObj= new Properties();
		pObj.load(fis);
		return pObj;
	}
}
