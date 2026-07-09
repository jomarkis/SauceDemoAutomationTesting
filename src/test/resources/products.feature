Feature: Product Page Functionality
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
    When The user clicks on "Reset App State"
    Then The cart should be empty and all buttons should be reset to "Add to cart"