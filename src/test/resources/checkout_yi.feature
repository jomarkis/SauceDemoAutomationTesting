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