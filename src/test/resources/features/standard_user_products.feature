@smoke
@regression  
Feature: Product Page Functionality for standard_user
  Scenario: Add and Remove a product from cart as standard_user
    Given The user is logged in as a "standard_user"
    When The user adds a product to the cart
    Then The cart badge should show "1" and the button should change to "Remove"
    And The user removes the product from the cart
    Then The cart badge should be empty and the button should change to "Add to cart"
  Scenario: Use menu bar as standard_user
    Given The user is logged in as a "standard_user"
    When The user adds a product to the cart
    And The user clicks on the menu bar
    Then The menu should be displayed
    When The user clicks on "All Items"
    Then The user should be redirected to the products page
    When The user clicks on "About"
    Then The user should be redirected to the Sauce LAB website
    When The user clicks on "Logout"
    Then The user should be logged out and redirected to the login page
    When The user enters username "standard_user" and password "secret_sauce"
    And The user clicks the login button
    And The user clicks on "Reset App State"
    Then The cart should be empty and all buttons should be reset to "Add to cart"
  Scenario: Navigation to a product's details page as standard_user
    Given The user is logged in as a "standard_user"
    When The user adds a product to the cart
    And The user clicks on a product's name
    Then The user should be redirected to the product's details page and the product's name, description, and price should be displayed
    And The "Add to cart" button should be displayed if the product is not in the cart, or the "Remove" button should be displayed if the product is already in the cart
    When The user clicks on "Add to cart" or "Remove" Button in the details page
    And The user clicks on the "Back to products" button
    Then The user should be redirected to the products page
    And The product's button should be updated to either "Add to cart" or "Remove" based on the previous action
  Scenario: Use product sorting functionality as standard_user
    Given The user is logged in as a "standard_user"
    When The user clicks on the product sorting container
    And The user clicks on option A-Z
    Then The products should be sorted in ascending order by name
    When The user clicks on the product sorting container
    And The user clicks on option Z-A
    Then The products should be sorted in descending order by name
    When The user clicks on the product sorting container
    And The user clicks on option Low-High
    Then The products should be sorted in ascending order by price
    When The user clicks on the product sorting container
    And The user clicks on option High-Low
    Then The products should be sorted in descending order by price


