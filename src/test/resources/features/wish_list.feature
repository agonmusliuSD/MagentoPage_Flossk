@wish_list
Feature: Verify that you're not able to add an item to wish list if you're not logged in

  Scenario: User tries to add an item to the wish list without being logged in
    Given User is on the Magento page
    When User clicks "Add to Wish List"
    Then User is redirected to the login page