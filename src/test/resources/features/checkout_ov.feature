Feature: Checkout Overview Functionality across users

  Scenario Outline: Verify the checkout overview page and "Finish" button functionality as "<username>"
    Given The user is logged in as a "<username>"
    When The user adds a product to the cart
    And The user clicks on the cart icon
    And The user clicks on the "Checkout" button
    And The user types the first name, last name, and postal code in each field
    And The user clicks on the "Continue" button
    Then The correct prices and total should be displayed on the checkout overview page
    When The user clicks on the "Finish" button
    Then The user should be redirected to the page with title "Checkout: Complete!"
    Examples:
      | username                |
      | standard_user           |
      | performance_glitch_user |
  Scenario Outline: Verify the checkout overview page and "Cancel" button functionality as "<username>"
    Given The user is logged in as a "<username>"
    When The user adds a product to the cart
    And The user clicks on the cart icon
    And The user clicks on the "Checkout" button
    And The user types the first name, last name, and postal code in each field
    And The user clicks on the "Continue" button
    And The user clicks on the "Cancel" button
    Then The user should be redirected to the products page with title "Products" within 2 seconds
  Examples:
      | username                |
      | standard_user           |
      | performance_glitch_user |
  Scenario Outline: Use menu bar as "<username>" in the checkout overview page
    Given The user is logged in as a "<username>"
    When The user adds a product to the cart
    And The user clicks on the cart icon
    And The user clicks on the "Checkout" button
    And The user types the first name, last name, and postal code in each field
    And The user clicks on the "Continue" button
    And The user clicks on the menu bar
    Then The menu should be displayed
    When The user clicks on "All Items"
    Then The user should be redirected to the products page
    When The user clicks on the menu bar
    And The user clicks on "About"
    Then The user should be redirected to the Sauce LAB website
    When The user clicks on "Logout"
    Then The user should be logged out and redirected to the login page
    When The user enters username "<username>" and password "secret_sauce"
    And The user clicks the login button
    And The user clicks on the cart icon
    And The user clicks on the "Checkout" button
    And The user types the first name, last name, and postal code in each field
    And The user clicks on the "Continue" button
    And The user clicks on "Reset App State"
    And The user clicks on "All Items"
    Then The cart should be empty and all buttons should be reset to "Add to cart"
    Examples:
      | username                |
      | standard_user           |
      | performance_glitch_user |