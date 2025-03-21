@cart
Feature: Shopping Cart functionality

  Scenario: Add items to cart, update quantity, remove item, and proceed to checkout
    Given I am on the shopping cart page
    When I update the quantity of the product to "2" 
    Then the quantity should be updated in the cart
    When I remove the product from the cart
    Then the cart should be empty
    When I navigate to the Wishlist page
    And I select a product from the Wishlist
    And I add the product to the cart again
    And I click on the checkout button
    Then the message Product Purchased should be displayed
    #And I capture a screenshot of the cart page
    
    #| quantity |
    #| 2        |


