Feature: Login function

  Scenario Outline: Success login functionality
    Given user is on  login page
    When user input valid username
    And user input valid password
    And user click Login button
    Then dashboard page displayed


  Scenario Outline: Failed login functionality
    Given user is on  login page
    When user input invalid username
    And user input invalid password
    And user click Login button
    Then fail message displayed
