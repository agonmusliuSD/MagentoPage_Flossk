@after_login @regression
Feature: Add an item to the wish list after logging in

  Scenario: User adds an item to the wish list after logging in
    Given User is on the homepage of Magento
    And User is logging in
    And User enter username and password
    And User clicks the Sign in button
    When User adds an item to the wish list
    Then The item is successfully added to the wish list