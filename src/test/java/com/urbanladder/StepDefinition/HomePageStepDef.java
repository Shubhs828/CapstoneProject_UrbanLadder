package com.urbanladder.StepDefinition;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.Pages.HomePage;
import com.urbanladder.utils.Base;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageStepDef extends Base{
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	
	HomePage homePage;
	
	@Given("I navigate to the UrbanLadder home page")
	public void i_navigate_to_the_urban_ladder_home_page() {
		homePage = new HomePage(driver, test);
	}

	@Then("Top Offers section should be displayed")
	public void top_offers_section_should_be_displayed() {
		boolean actResult = homePage.verifyTopOffers();
        Assert.assertTrue("Top Offers section is not displayed", actResult);
        System.out.println("offer section is displayed");
	   
	}

	@Then("Recommended for You section should be displayed")
	public void recommended_for_you_section_should_be_displayed() {
		 boolean actResult = homePage.verifyRecommendedForYou();
	     Assert.assertTrue("Recommended For You section is not displayed", actResult);
	     System.out.println("bestseller is displayed..");
	   
	}

	@Then("Search bar should be functional")
	public void search_bar_should_be_functional() {
		 boolean actResult = homePage.verifySearchBar();
	     Assert.assertTrue("Search bar is not functional", actResult);
	     System.out.println("Search bar is functional...");
	    
	}


}
