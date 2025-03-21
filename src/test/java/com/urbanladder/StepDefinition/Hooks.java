package com.urbanladder.StepDefinition;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.urbanladder.utils.Base;
import com.urbanladder.utils.Reports;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks extends Base {
	static WebDriver driver = Base.driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeAll()
	public static void beforeAll() {

		try {
			sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);

			Base base = new Base();
			base.getBrowser();
			driver = Base.driver;

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Error initializing Extent Reports: " + e.getMessage());
		}
	}

	@AfterAll()
	public static void afterAll() {
		if (extent != null) {
			extent.flush();
		}
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	@Before()
	public void before(Scenario scenario) {
		if (driver == null) { // Ensure the browser is open
			Base base = new Base();
			base.getBrowser();
			driver = Base.driver;
		}

		test = extent.createTest(scenario.getName());

		if (scenario.getSourceTagNames().contains("@UserAuthentication")
				|| scenario.getSourceTagNames().contains("@Login")
				|| scenario.getSourceTagNames().contains("@AccountSettings")) {
			System.out.println("Continuing session for Authentication tests.");
			return;
		}
	}

	@After()
	public void after(Scenario scenario) {
//		if (scenario.isFailed()) {
//			System.out.println("Scenario failed: Taking a screenshot...");
//			String screenshotPath = Reports.captureScreenshot(driver, scenario.getName());
//			test.fail("Test failed. Screenshot: " + screenshotPath);
//		}
		System.out.println("Completed scenario: " + scenario.getName());
	}

}
