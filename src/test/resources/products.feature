Feature: Product Page Functionality
  Scenario: Add and Remove a product from cart as standard_user
    Given The user is logged in as a "standard_user"
    When The user adds a product to the cart
    Then The cart badge should show "1"
    And The user removes the product from the cart
    Then The cart badge should be empty
  Scenario: