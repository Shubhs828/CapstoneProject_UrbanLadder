package com.urbanladder.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Reports {
	
	public static void generateReport(WebDriver driver, ExtentTest test, Status status,String stepMessage){
		if (status.equals(Status.PASS)) {
			test.log(status, stepMessage);
		}else if (status.equals(Status.FAIL)) {
			String screenShotName = captureScreenshot(driver, stepMessage);
			test.log(status, stepMessage, MediaEntityBuilder.createScreenCaptureFromPath(screenShotName).build());
		}
		
		
	}

	public static String captureScreenshot(WebDriver driver, String errorMessage) {
		
		String userDir = System.getProperty("user.dir"); 
		// to take time stamp
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss"); // yyyy-MM-dd
		String dateTime = df.format(date); // 27-01-2025_16_43_54
		String fileName = userDir + ".\\screenshots\\" + errorMessage + "_" + dateTime + ".png";

		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(fileName); // fileName System.currentTimeMillis()
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) 
		{		
			e.printStackTrace();
		}
				
		return fileName;
		
	}

}
