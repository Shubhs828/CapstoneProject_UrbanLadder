@HomeValidation
Feature: Home Page Validation
	
	
  Scenario: Verify Home Page Elements
    Given I navigate to the UrbanLadder home page
    Then Top Offers section should be displayed
    And Recommended for You section should be displayed
    And Search bar should be functional

