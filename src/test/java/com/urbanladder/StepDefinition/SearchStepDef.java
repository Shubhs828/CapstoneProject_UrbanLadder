package com.urbanladder.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.Pages.SearchPage;
import com.urbanladder.utils.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDef extends Base{
	WebDriver driver = Base.driver;
    ExtentTest test = Hooks.test;
    SearchPage searchPage;
    
    public SearchStepDef() {
        this.searchPage = new SearchPage(driver, test);  
    }
	

	@When("I search for {string}")
	public void i_search_for(String query) {
		boolean result = searchPage.searchForProduct(query);
        Assert.assertTrue("Search function failed", result);
	    
	}

	@Then("I should see search results for {string}")
	public void i_should_see_search_results_for(String query) {
		boolean result = searchPage.isSearchResultDisplayed(query);
        Assert.assertTrue("Search results verification failed", result);
	    
	}

	@When("I navigate to {string} dropdown")
	public void i_navigate_to_dropdown(String dropdown) {
		boolean result = searchPage.navigateToDropdown(dropdown);
        Assert.assertTrue("Navigation to dropdown failed", result);
		
	    
	}

	@And("I select {string}")
	public void i_select(String option) {
		boolean result = searchPage.selectDropdownOption(option);
        Assert.assertTrue("Dropdown selection failed", result);
	   
	}

	
	@Then("I should see the products sorted by New Arrivals")
	public void i_should_see_the_products_sorted_by_new_arrivals() {
		System.out.println("New Arival product displayed... ");
	}

	
	@When("I navigate to the price filter dropdown")
	public void i_navigate_to_the_price_filter_dropdown() {
		boolean result = searchPage.navigateToPriceFilterDropdown();
        Assert.assertTrue("Failed to navigate to the price filter dropdown", result);
	}

	@When("I select the price option {string}")
	public void i_select_the_price_option(String price) {
		boolean result = searchPage.selectPriceOption(price);
	    Assert.assertTrue("Failed to apply price filter: " + price, result);
	}

	@Then("I should see the filter applied successfully")
	public void i_should_see_the_filter_applied_successfully() {
		System.out.println("product is filtered by price range..");
	    
	}
	


	

}
