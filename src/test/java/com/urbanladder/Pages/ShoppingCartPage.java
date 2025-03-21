package com.urbanladder.Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.urbanladder.Objectrepo.Locators;
import com.urbanladder.utils.Reports;

public class ShoppingCartPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	public ShoppingCartPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
	}

    public void updateQuantity(String quantity) {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.Quantity_Dropdown));
            Select select = new Select(dropdown);
            select.selectByVisibleText(quantity);
            Reports.generateReport(driver, test, Status.PASS, "Updated product quantity to " + quantity);
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to update product quantity");
        }
    }


	public void removeProductFromCart() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Locators.deleteButton)).click();
			Reports.generateReport(driver, test, Status.PASS, "Removed product from cart");
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Failed to remove product from cart");
		}
	}

	public boolean isCartEmpty() {
		try {
			boolean empty = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emptyCartMessage))
					.isDisplayed();
			Reports.generateReport(driver, test, Status.PASS, "Cart empty verification result: " + empty);
			return empty;
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Failed to verify if cart is empty");
			return false;
		}
	}

	public void goToWishlist() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Locators.wishlistLink)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.wishlistLink));
			Reports.generateReport(driver, test, Status.PASS, "Navigated to wishlist");
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Failed to navigate to wishlist");
		}
	}

	public void selectProductFromWishlist() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Locators.WISHLIST_PRODUCT)).click();
			Reports.generateReport(driver, test, Status.PASS, "Selected product from wishlist");
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Failed to select product from wishlist");
		}
	}

	public void addToCart() {
		try {
			WebElement addToCartButton = wait
					.until(ExpectedConditions.elementToBeClickable(Locators.ADD_TO_CART_BUTTON));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", addToCartButton);
			addToCartButton.click();
			Reports.generateReport(driver, test, Status.PASS, "Added product to cart");
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Failed to add product to cart");
		}
	}

//	public void proceedToCheckout() {
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(Locators.checkoutButton)).click();
//			Reports.generateReport(driver, test, Status.PASS, "Proceeded to checkout");
//		} catch (TimeoutException e) {
//			Reports.generateReport(driver, test, Status.FAIL, "Failed to proceed to checkout");
//		}
//	}
	
	public void proceedToCheckout() {
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(Locators.checkoutButton)).click();
	        
	        // Capture screenshot after clicking the checkout button
	        String screenshotPath = Reports.captureScreenshot(driver, "Checkout_Success");

	        // Generate report with screenshot for a passed test
	        test.log(Status.PASS, "Proceeded to checkout", 
	                 MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    } catch (TimeoutException e) {
	        // Capture screenshot in case of failure
	        String screenshotPath = Reports.captureScreenshot(driver, "Checkout_Failure");

	        // Generate report with screenshot for a failed test
	        test.log(Status.FAIL, "Failed to proceed to checkout", 
	                 MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	}

}
