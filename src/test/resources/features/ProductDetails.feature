@Details
Feature: Product Details Page Validation and Interaction

  Scenario: End-to-End Product Selection, Validation, Wishlist, and Cart Addition
  
    When I find and click on "Taran Teak Wood Sofa"

    Then I validate the product title
    And I check if "Taran Teak Wood Sofa" is sold out
    Then I validate the product description
    And I validate the product price

    When I click on the wishlist icon
    And I navigate to the wishlist page
    Then I validate that "Taran Teak Wood Sofa" is added to the wishlist
    And I click on the product from the wishlist

    When I click on the "Add to Cart" button
    Then I validate that "Taran Teak Wood Sofa" is added to the cart

