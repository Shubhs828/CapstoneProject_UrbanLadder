package com.urbanladder.Pages;
import java.time.Duration;
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

public class UserAuthenticationPage {
	private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private ExtentTest test;

    public UserAuthenticationPage(WebDriver driver, ExtentTest test) {
       
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
        this.test = test;
    }

    private void hoverOverProfileIcon() {
    	try {
        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Profile_icon));
        actions.moveToElement(profileIcon).perform();
        Reports.generateReport(driver, test, Status.PASS, "Hovered over profile icon");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to hover over profile icon");
        }
    }

    public void clickSignUpLink() {
    	try {
        hoverOverProfileIcon();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SignUp_Link)).click();
        Reports.generateReport(driver, test, Status.PASS, "Clicked on SignUp link");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click on SignUp link");
        }
    }

    public void fillRegistrationForm(String email, String password) {
    	try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Email_Field)).sendKeys(email);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Password_Field)).sendKeys(password);
        Reports.generateReport(driver, test, Status.PASS, "Filled registration form successfully");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to fill registration form");
        }
    }

    public void clickSignUpButton() {
    	 try {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SignUp_Button)).click();
        Reports.generateReport(driver, test, Status.PASS, "Clicked on SignUp button");
         } catch (TimeoutException e) {
             Reports.generateReport(driver, test, Status.FAIL, "Failed to click on SignUp button");
         }
    }

//    public void clickLoginLink() {
//        hoverOverProfileIcon();
//        wait.until(ExpectedConditions.elementToBeClickable(Locators.Login_Link)).click();
//    }

    public void enterLoginCredentials(String email, String password) {
    	try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Login_Email_Field)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.login_Password_Field)).sendKeys(password);
        Reports.generateReport(driver, test, Status.PASS, "Entered login credentials");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter login credentials");
        }
    }

    public void clickLoginButton() {
    	try {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.Login_Button)).click();
    	} catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click on Login button");
        }
    }

    public void clickProfileDropdown() {
    	try {
        hoverOverProfileIcon();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.Profile)).click();
        Reports.generateReport(driver, test, Status.PASS, "Clicked on Profile dropdown");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click on Profile dropdown");
        }
    }
    
    public void clickEditButton() {
    	 try {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.Edit)).click();
        Reports.generateReport(driver, test, Status.PASS, "Clicked on Edit button");
         } catch (TimeoutException e) {
             Reports.generateReport(driver, test, Status.FAIL, "Failed to click on Edit button");
         }
    }

    public void updateName(String newName) {
    	try {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Name_Field));
        nameField.clear();
        nameField.sendKeys(newName);
        Reports.generateReport(driver, test, Status.PASS, "Updated name successfully");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to update name");
        }
    }
        

    public void updateMobileNumber(String newMobile) {
    	try {
        WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Mobile_Field));
        mobileField.clear();
        mobileField.sendKeys(newMobile);
        Reports.generateReport(driver, test, Status.PASS, "Updated mobile number successfully");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to update mobile number");
        }
    }
    
    public void clickChangePasswordButton() {
    	try {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.Change_Password)).click();
    	} catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click on Change Password button");
        }
    }

    public void updatePassword(String newPassword, String confirmPassword) {
    	try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.New_Password_Field)).sendKeys(newPassword);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Confirm_Password_Field)).sendKeys(confirmPassword);
        Reports.generateReport(driver, test, Status.PASS, "Updated password successfully");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to update password");
        }
    }

    public void clickUpdateButton() {
    	try {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.Save_Changes_Button)).click();
        Reports.generateReport(driver, test, Status.PASS, "Clicked on Update button");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click on Update button");
        }
    }
    

    public String getProfileUpdateSuccessMessage() {
    	try {
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Success_Message));
        Reports.generateReport(driver, test, Status.PASS, "Profile update success message displayed");
        return successMsg.getText();
    	} catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Profile update success message not displayed");
            return null;
        }
    }
    
    public boolean isLoginSuccessful() {
    	 try {
//        return driver.findElements(Locators.Login_Failure_Message).isEmpty();
    		 boolean isSuccess = driver.findElements(Locators.Login_Failure_Message).isEmpty();
             if (isSuccess) {
                 Reports.generateReport(driver, test, Status.PASS, "Login was successful");
             } else {
                 Reports.generateReport(driver, test, Status.FAIL, "Login failed");
             }
             return isSuccess;
         } catch (TimeoutException e) {
             Reports.generateReport(driver, test, Status.FAIL, "Error checking login status");
             return false;
         }
    }

    

}
