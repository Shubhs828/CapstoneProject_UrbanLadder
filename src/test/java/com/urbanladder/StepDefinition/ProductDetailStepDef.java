package com.urbanladder.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.Pages.ProductDetailPage;
import com.urbanladder.utils.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailStepDef {
	
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	
	ProductDetailPage  prodDetailPage;
	

    public ProductDetailStepDef() {
        this.prodDetailPage = new ProductDetailPage(driver, test);
    }
	
	@When("I find and click on {string}")
	public void i_find_and_click_on(String productName) {
		prodDetailPage.findAndClickProduct(productName);
	}

	@Then("I validate the product title")
	public void i_validate_the_product_title() {
//		prodDetailPage.validateProductTitle();
		String actualTitle = prodDetailPage.validateAndGetProductTitle();
	    String expectedTitle = "Taran Teak Wood Sofa (Sunset Ikat Stripes)"; 
	    Assert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
	    
	}

	@And("I check if {string} is sold out")
	public void i_check_if_is_sold_out(String productName) {
		prodDetailPage.validateProductAvailability();
	   
	}

	@Then("I validate the product description")
	public void i_validate_the_product_description() {
//		prodDetailPage.validateProductDescription();
		String productDescription = prodDetailPage.validateAndGetProductDescription();
	    String expectedDescription = "Product Details"; 
//	    Assert.assertEquals("Product description does not match", expectedDescription, productDescription);
	    Assert.assertTrue(expectedDescription.equalsIgnoreCase(productDescription));
	}

	@And("I validate the product price")
	public void i_validate_the_product_price() {
//		prodDetailPage.validateProductPrice();
		String productPrice = prodDetailPage.validateAndGetProductPrice();
	    String expectedPrice = "₹63,008"; 
//	    Assert.assertEquals("Product price does not match", expectedPrice, productPrice);
	    Assert.assertTrue(expectedPrice.equalsIgnoreCase(productPrice));
	    
	}

	@When("I click on the wishlist icon")
	public void i_click_on_the_wishlist_icon() {
		 prodDetailPage.addToWishlist();
		 
	    
	}

	
	@And("I navigate to the wishlist page")
	public void i_navigate_to_the_wishlist_page() {
		prodDetailPage.navigateToWishlist();
		
		
	   
	}

	@Then("I validate that {string} is added to the wishlist")
	public void i_validate_that_is_added_to_the_wishlist(String expectedProductName) {
		boolean isInWishlist = prodDetailPage.validateWishlist(expectedProductName);
        if (!isInWishlist) {
            throw new AssertionError(expectedProductName + " is NOT in the wishlist");
        }
	    
	}

	@And("I click on the product from the wishlist")
	public void i_click_on_the_product_from_the_wishlist() {
		 prodDetailPage.findAndClickProduct("Wishlist Product");
	    
	}

	@When("I click on the {string} button")
	public void i_click_on_the_button(String buttonName) {
		if (buttonName.equalsIgnoreCase("Add to Cart")) {
            prodDetailPage.addToCart();
        }
	    
	}

	@Then("I validate that {string} is added to the cart")
	public void i_validate_that_is_added_to_the_cart(String expectedProductName) {
		boolean isInCart = prodDetailPage.validateCart(expectedProductName);
        if (!isInCart) {
            throw new AssertionError(expectedProductName + " is NOT in the cart");
        }
	    
	}

	
	
	
	
	

}
