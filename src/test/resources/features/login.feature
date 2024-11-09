@login  @regression
Feature: User Login

  Scenario: User logs in with valid credentials
    Given User is on the login page
    When User enters a valid username and password
    And User clicks on the login button
    Then User should be logged in successfully