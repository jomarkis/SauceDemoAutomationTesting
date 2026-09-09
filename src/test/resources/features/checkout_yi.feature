Feature: Checkout Your Information Functionality across users

  Scenario Outline: Verify the checkout your information page and "Continue" button functionality as "<username>"
    Given The user is logged in as a "<username>"
    When The user adds a product to the cart
    And The user clicks on the cart icon
    And The user clicks on the "Checkout" button
    Then The user should be redirected to the page with title "Checkout: Your Information"
    When The user types the first name, last name, and postal code in each field
    Then The correct values should be displayed in each field
    When The user clicks on the "Continue" button
    Then The user should be redirected to the page with title "Checkout: Overview"

    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
  Scenario Outline: Use menu bar as "<username>" in the checkout your information page
    Given The user is logged in as a "<username>"
    When The user adds a product to the cart
    And The user clicks on the cart icon
    And The user clicks on the "Checkout" button
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
    And The user clicks on "Reset App State"
    And The user clicks on "All Items"
    Then The cart should be empty and all buttons should be reset to "Add to cart"
    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |