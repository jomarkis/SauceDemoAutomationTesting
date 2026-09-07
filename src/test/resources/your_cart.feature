Feature: Your Cart Functionality
  Scenario: Verify product in the cart and its button
    Given The user is logged in as a "standard_user"
    When The user adds a product to the cart
    And The user clicks on the cart icon
    Then The user should be redirected to the page with title "Your Cart"
    And The "Remove" button should be displayed for the product in the cart
