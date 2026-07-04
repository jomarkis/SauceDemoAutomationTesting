Feature: Login Functionality

  Scenario: Successful login with standard user
    Given The user opens the SauceDemo website in Firefox
    When The user enters username "standard_user" and password "secret_sauce"
    And The user clicks the login button
    Then The user should be redirected to the products page with title "Products"

  Scenario: Unsuccessful login with locked out user
    Given The user opens the SauceDemo website in Firefox
    When The user enters username "locked_out_user" and password "secret_sauce"
    And The user clicks the login button
    Then An error message should be displayed with text "Epic sadface: Sorry, this user has been locked out."

  Scenario: Successful login with problem user
    Given The user opens the SauceDemo website in Firefox
    When The user enters username "problem_user" and password "secret_sauce"
    And The user clicks the login button
    Then The user should be redirected to the products page with title "Products"

  Scenario: Successful login with performance glitch user
    Given The user opens the SauceDemo website in Firefox
    When The user enters username "performance_glitch_user" and password "secret_sauce"
    And The user clicks the login button
    Then The user should be redirected to the products page with title "Products" within 2 seconds
