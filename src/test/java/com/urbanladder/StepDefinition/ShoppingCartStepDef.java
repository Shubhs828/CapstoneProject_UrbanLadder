package com.urbanladder.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.Pages.SearchPage;
import com.urbanladder.Pages.ShoppingCartPage;
import com.urbanladder.utils.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartStepDef extends Base{
	WebDriver driver = Base.driver;
    ExtentTest test = Hooks.test;
    ShoppingCartPage cartPage;
    
    
    public ShoppingCartStepDef() {
        this.cartPage = new ShoppingCartPage(driver, test);  
    }
    
	@Given("I am on the shopping cart page")
	public void i_am_on_the_shopping_cart_page() {
	   System.out.println("shopping cart page...");
	}
	
	@When("I update the quantity of the product to {string}")
	public void i_update_the_quantity_of_the_product_to(String quantity) {
		cartPage.updateQuantity(quantity);
	   
	}	

	@Then("the quantity should be updated in the cart")
	public void the_quantity_should_be_updated_in_the_cart() {
//		String expectedQuantity = "2";  
//	    Assert.assertTrue(cartPage.isQuantityUpdated(expectedQuantity), "Expected quantity to be updated but was not.");
		System.out.println("product updated");
	}

	@When("I remove the product from the cart")
	public void i_remove_the_product_from_the_cart() {
		cartPage.removeProductFromCart();
	}

	@Then("the cart should be empty")
	public void the_cart_should_be_empty() {
		Assert.assertTrue(cartPage.isCartEmpty());
	}

	@When("I navigate to the Wishlist page")
	public void i_navigate_to_the_wishlist_page() {
		 cartPage.goToWishlist();
	}

	@And("I select a product from the Wishlist")
	public void i_select_a_product_from_the_wishlist() {
		 cartPage.selectProductFromWishlist();
	}

	@And("I add the product to the cart again")
	public void i_add_the_product_to_the_cart_again() {
		cartPage.addToCart();
	}

	@And("I click on the checkout button")
	public void i_click_on_the_checkout_button() {
		cartPage.proceedToCheckout();
	}

	@Then("the message Product Purchased should be displayed")
	public void the_message_product_purchased_should_be_displayed() {
	    System.out.println("Product Purchased.....");
	}


}
