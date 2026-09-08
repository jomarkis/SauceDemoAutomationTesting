Feature: Your Cart Functionality for standard_user
  Scenario: Verify product in the cart, "Remove" and "Continue Shopping" button functionality as standard_user
    Given The user is logged in as a "standard_user"
    When The user adds a product to the cart
    And The user clicks on the cart icon
    Then The user should be redirected to the page with title "Your Cart"
    And The "Remove" button should be displayed for the product in the cart
    When The user clicks on the "Remove" button for the product in the cart
    Then The product should be removed from the cart
    When The user clicks on the "Continue Shopping" button
    Then The cart badge should be empty and the button should change to "Add to cart"
    And The user should be redirected to the products page
  Scenario: Use menu bar as standard_user in the cart page
    Given The user is logged in as a "standard_user"
    When The user adds a product to the cart
    And The user clicks on the cart icon
    And The user clicks on the menu bar
    Then The menu should be displayed
    When The user clicks on "All Items"
    Then The user should be redirected to the products page
    When The user clicks on the menu bar
    And The user clicks on "About"
    Then The user should be redirected to the Sauce LAB website
    When The user clicks on "Logout"
    Then The user should be logged out and redirected to the login page
    When The user enters username "standard_user" and password "secret_sauce"
    And The user clicks the login button
    And The user clicks on the cart icon
    And The user clicks on "Reset App State"
    And The user clicks on "All Items"
    Then The cart should be empty and all buttons should be reset to "Add to cart"