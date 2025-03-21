package com.urbanladder.Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {
	    	"src/test/resources/features/Home.feature",	    		
	       "src/test/resources/features/Login.feature",
	       "src/test/resources/features/OrderSearch.feature",
	       "src/test/resources/features/ProductDetails.feature",
	       "src/test/resources/features/ShoppingCart.feature"
	       
	    },
	    glue = "com.urbanladder.StepDefinition",
	    		plugin = {"pretty","html:reports/HTMLReports.html",
						"json:reports/json-report.json",
						"junit:reports/junit_report.xml",
						"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
	    }
	)


public class TestRunner extends AbstractTestNGCucumberTests{

}
