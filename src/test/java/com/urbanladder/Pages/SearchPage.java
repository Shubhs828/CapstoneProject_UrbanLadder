package com.urbanladder.Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.Objectrepo.Locators;
import com.urbanladder.utils.Reports;

import com.aventstack.extentreports.ExtentTest;

public class SearchPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	private ExtentTest test;

	public SearchPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions = new Actions(driver);
		this.test = test;
	}

	public boolean searchForProduct(String product) {
		try {
			WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(Locators.Search_Bar));
			searchInput.clear();
			searchInput.sendKeys(product);
			driver.findElement(Locators.Search_Button).click();
			Reports.generateReport(driver, test, Status.PASS, "Searched for product: " + product);
			return true;
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Failed to search for product: " + product);
			return false;
		}
	}

	public boolean isSearchResultDisplayed(String product) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Search_Result_Header));
			String actualText = searchResult.getText().trim().toLowerCase();
			boolean result = actualText.contains("search results for") && actualText.contains(product.toLowerCase());
			if (result) {
				Reports.generateReport(driver, test, Status.PASS, "Search results displayed correctly for: " + product);
			} else {
				Reports.generateReport(driver, test, Status.FAIL,
						"Search results mismatch. Expected product in: " + actualText);
			}

			return result;
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Search results not displayed for: " + product);
			return false;
		}
	}

	public boolean navigateToDropdown(String dropdown) {
		try {
			WebElement dropdownElement = wait
					.until(ExpectedConditions.elementToBeClickable(Locators.Recommended_Dropdown));
			dropdownElement.click();
			Reports.generateReport(driver, test, Status.PASS, "Navigated to dropdown: " + dropdown);
			return true;
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Failed to navigate to dropdown: " + dropdown);
			return false;
		}
	}

	public boolean selectDropdownOption(String option) {
		try {
			WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.New_Arrivals_Option));
			optionElement.click();
			Reports.generateReport(driver, test, Status.PASS, "Selected dropdown option: " + option);
			return true;
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Failed to select dropdown option: " + option);
			return false;
		}
	}
	
	
	public boolean navigateToPriceFilterDropdown() {
	    try {
	        WebElement priceFilterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Price_Filter));
	        
	        // Scroll into view to ensure visibility
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", priceFilterDropdown);	        
	        wait.until(ExpectedConditions.elementToBeClickable(priceFilterDropdown)).click();

	        Reports.generateReport(driver, test, Status.PASS, "Navigated to price filter dropdown");
	        return true;
	    } catch (Exception e) {
	        Reports.generateReport(driver, test, Status.FAIL, "Failed to navigate to price filter dropdown: " + e.getMessage());
	        return false;
	    }
	}


	public boolean selectPriceOption(String priceRange) {
	    try {
	        WebElement priceRangeOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.Price_Range));
	        priceRangeOption.click();
	        Reports.generateReport(driver, test, Status.PASS, "Selected price option: " + priceRange);
	        return true;
	    } catch (TimeoutException e) {
	        Reports.generateReport(driver, test, Status.FAIL, "Failed to select price option: " + priceRange);
	        return false;
	    }
	}

	

}
