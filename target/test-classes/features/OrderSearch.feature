    
#@search    
#Feature: Search and Filter Functionality on Urban Ladder
#
  #Scenario Outline: Search and filter products
    #Given I am on the Urban Ladder homepage
    #When I search for "sofa"
    #Then I should see search results for "sofa"
    #
    #When I navigate to "Recommended" dropdown
    #And I select "New Arrivals"
    #Then I should see the products sorted by New Arrivals  
        #
    #When I navigate to the price filter dropdown  
    #And I select the price option "<price>"
#		Then I should see the filter applied successfully
    #
    #Example:
    #| price              |
    #| ₹53,081-₹104,560   |  
    
    
    
@search
Feature: Search and Filter Functionality on Urban Ladder

  Scenario Outline: Search and filter products

    
    When I search for "<product>"
    Then I should see search results for "<product>"

    When I navigate to "Recommended" dropdown
    And I select "New Arrivals"
    Then I should see the products sorted by New Arrivals  

    When I navigate to the price filter dropdown  
    And I select the price option "<price>"
    Then I should see the filter applied successfully

  Examples:
    | price              | product |
    | ₹53,081-₹104,560   | sofa    |
                
    
    
    


    
