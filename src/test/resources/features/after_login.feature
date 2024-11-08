@after_login
Feature: Add an item to the wish list after logging in

  Scenario: User adds an item to the wish list after logging in
    Given User is on the login page
    And User enter username and password and clicks on sign in button
    When User adds an item to the wish list
    Then The item is successfully added to the wish list