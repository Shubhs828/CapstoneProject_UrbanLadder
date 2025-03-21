package com.urbanladder.Pages;


import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.Objectrepo.Locators;
import com.urbanladder.utils.Reports;

public class HomePage {
	private WebDriver driver;
    private WebDriverWait wait;
    ExtentTest test;
    
    public HomePage(WebDriver driver, ExtentTest test) {
//        super();
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.test = test;
    }
    
    public boolean verifyTopOffers() {
        boolean actResult = true;
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Top_Offers));
            Reports.generateReport(driver, test, Status.PASS, "Top Offers section is displayed");
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Top Offers section is not displayed");
        }
        return actResult;
    }
    
    public boolean verifyRecommendedForYou() {
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.BestSeller));
            Reports.generateReport(driver, test, Status.PASS, "BestSeller section is displayed");
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "BestSeller section is not displayed");
        }
        return actResult;
    }
    
    public boolean verifySearchBar() {
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Search_Bar));
            Reports.generateReport(driver, test, Status.PASS, "Search bar is displayed");
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Search bar is not displayed");
        }
        return actResult;
    }

}
