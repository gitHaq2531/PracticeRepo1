package com.client.shoProd.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils 
{
public String getdataFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream("src/test/resources/commonDataFor_shoProd.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String data=pobj.getProperty(key);
	return data;
	}
}
