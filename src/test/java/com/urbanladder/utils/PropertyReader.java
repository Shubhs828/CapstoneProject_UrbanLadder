package com.urbanladder.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static Properties readProperty() {
		Properties prop = null;
		String fileName = "src\\test\\resources\\config\\config.properties";
		try {
			FileInputStream fis  = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);				
		}catch(FileNotFoundException e) {
			System.out.println("File name or file path is not correct");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
