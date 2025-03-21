package com.urbanladder.Pages;


import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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

public class ProductDetailPage {
	private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private ExtentTest test;
    
    public ProductDetailPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
        this.test = test;
    }
    
    
    public void findAndClickProduct(String productName) {
        try {
            WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.SELECT_PRODUCT));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", product);
            wait.until(ExpectedConditions.visibilityOf(product));
            wait.until(ExpectedConditions.elementToBeClickable(product));
            
            actions.moveToElement(product).perform();
            product.click();
            
            Reports.generateReport(driver, test, Status.PASS, "Clicked on " + productName);
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Product " + productName + " not found");
        } catch (StaleElementReferenceException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Product element became stale, retrying...");
            findAndClickProduct(productName); 
        }
    }
    

    
    public String validateAndGetProductTitle() {
        try {
            WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.PRODUCT_TITLE));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", productTitle);
            System.out.println(productTitle.getText());
            String productTitleText = productTitle.getText();
            Reports.generateReport(driver, test, Status.PASS, "Validated product title: " + productTitleText);            
            return productTitleText;
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to validate product title");
            return null; 
        }
    }

    

    
    public void validateProductAvailability() {
        boolean isSoldOut;
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.presenceOfElementLocated(Locators.OUT_OF_STOCK_LABEL));
            WebElement outOfStockElement = driver.findElement(Locators.OUT_OF_STOCK_LABEL);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", outOfStockElement);
            isSoldOut = true;
        } catch (TimeoutException e) {
            isSoldOut = false;
        }

        if (isSoldOut) {
            Reports.generateReport(driver, test, Status.FAIL, "Product is out of stock");
        } else {
            Reports.generateReport(driver, test, Status.PASS, "Product is available");
        }
    }


    
    public String validateAndGetProductDescription() {
        try {
            WebElement productDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.PRODUCT_DESCRIPTION));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", productDescription);
            System.out.println(productDescription.getText());
            String productDescriptionText = productDescription.getText();
            Reports.generateReport(driver, test, Status.PASS, "Validated product description: " + productDescriptionText);
            return productDescriptionText;
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to validate product description");
            return null; 
        }
    }

    public String validateAndGetProductPrice() {
        try {
            WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.PRODUCT_PRICE));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", productPrice);
            System.out.println(productPrice.getText());
            String productPriceText = productPrice.getText();
            Reports.generateReport(driver, test, Status.PASS, "Validated product price: " + productPriceText);
            return productPriceText;
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to validate product price");
            return null; 
        }
    }


    
    public void addToWishlist() {
    	try {
            WebElement wishlistIcon = wait.until(ExpectedConditions.elementToBeClickable(Locators.WISHLIST_ICON));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", wishlistIcon);            
            wishlistIcon.click();
            Reports.generateReport(driver, test, Status.PASS, "Added product to wishlist");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to add product to wishlist");
        }
    }

   
    public void navigateToWishlist(){
    	try {
    		WebElement wishlistPage = wait.until(ExpectedConditions.elementToBeClickable(Locators.WISHLIST_PAGE));
    		Thread.sleep(2000); 
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", wishlistPage);            
            wishlistPage.click();
            Reports.generateReport(driver, test, Status.PASS, "Navigated to wishlist page");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to navigate to wishlist page");
        } catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    }

    
    public boolean validateWishlist(String expectedProductName) {
        try {
            WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.WISHLIST_PRODUCT));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", productTitle);  
            if (productTitle.getText().equalsIgnoreCase(expectedProductName)) {
                Reports.generateReport(driver, test, Status.PASS, expectedProductName + " is in the wishlist");
                return true;
            } else {
                Reports.generateReport(driver, test, Status.FAIL, expectedProductName + " is NOT in the wishlist");
                return false;
            }
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to validate wishlist");
            return false;
        }
    }

    public void addToCart() {
        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_TO_CART_BUTTON));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", addToCartButton);            
            addToCartButton.click();
            Reports.generateReport(driver, test, Status.PASS, "Added product to cart");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to add product to cart");
        }
    }

    public boolean validateCart(String expectedProductName) {
        try {
            WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CART_PAGE_PRODUCT_TITLE));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", productTitle);            
            if (productTitle.getText().equalsIgnoreCase(expectedProductName)) {
                Reports.generateReport(driver, test, Status.PASS, expectedProductName + " is in the cart");
                return true;
            } else {
                Reports.generateReport(driver, test, Status.FAIL, expectedProductName + " is NOT in the cart");
                return false;
            }
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to validate cart");
            return false;
        }
    }
  
}



