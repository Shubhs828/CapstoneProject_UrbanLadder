package com.urbanladder.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.Objectrepo.Locators;
import com.urbanladder.Pages.UserAuthenticationPage;
import com.urbanladder.utils.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class UserRegistrationStepDef extends Base {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	UserAuthenticationPage userAuthPage;

    public UserRegistrationStepDef() {
        this.userAuthPage = new UserAuthenticationPage(driver, test);
    }
    
	@Given("I navigate to the Sign Up link under profile icon")
	public void i_navigate_to_the_sign_up_link_under_profile_icon() {
		userAuthPage.clickSignUpLink();
		
	}

	@When("I enter {string} and {string} for registration")
	public void i_enter_and_for_registration(String email, String password) {
		userAuthPage.fillRegistrationForm(email, password);
		
	}

	@And("I click on the Sign Up button")
	public void i_click_on_the_sign_up_button() {
		userAuthPage.clickSignUpButton();
		
	}

	@Then("the user should be successfully logged in")
	public void the_user_should_be_successfully_logged_in() {
		System.out.println("user registered successfilly");
		
	}

	@Given("I navigate to the profile under profile icon")
	public void i_navigate_to_the_profile_under_profile_icon() {
		userAuthPage.clickProfileDropdown();
		
	}

	@And("I clicks on edit button")
	public void i_clicks_on_edit_button() {
		userAuthPage.clickEditButton();
		
	}

	@And("I enter my name in {string}")
	public void i_enter_my_name_in(String username) {
		userAuthPage.updateName(username);
		
	}

	@And("I enter my mobile number to {string}")
	public void i_enter_my_mobile_number_to(String mobile) {
		userAuthPage.updateMobileNumber(mobile);
		
	}

	@And("I click on the Change Password option")
	public void i_click_on_the_change_password_option() {
		userAuthPage.clickChangePasswordButton();
		
	}

	@And("I update my password to {string} and confirm it as {string}")
	public void i_update_my_password_to_and_confirm_it_as(String newPassword, String confirmPassword) {
		userAuthPage.updatePassword(newPassword, confirmPassword);
		
	}

	@And("I click on the Update button")
	public void i_click_on_the_update_button() {
		userAuthPage.clickUpdateButton();
		
	}

	@Then("I get {string} message as success")
	public void i_get_message_as_success(String message) {
		Assert.assertEquals("Profile update failed!", message, userAuthPage.getProfileUpdateSuccessMessage());
		
	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
//		 userAuthPage.clickLoginLink();
		System.out.println("user is on the login page..");
		
	}

	@When("I enter email {string} and password {string}")
	public void i_enter_email_and_password(String email, String password) {
		userAuthPage.enterLoginCredentials(email, password);
		
	}


	@And("I click on the Login button")
	public void i_click_on_the_login_button() {
		userAuthPage.clickLoginButton();
		
	}

	@Then("I should see {string}")
	public void i_should_see(String string) {
		Assert.assertTrue("Login failed! Incorrect email or password.", userAuthPage.isLoginSuccessful());
		System.out.println("successfully loged in..");
		
	}

}
