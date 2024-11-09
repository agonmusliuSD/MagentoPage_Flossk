@add_multiple_items  @regression
Feature: Add multiple items to cart and place an order

  Scenario: User adds multiple items to the cart and completes the checkout
    Given User is on the main page
    When User adds multiple items to the cart
    And User proceeds to checkout
    And User enters shipping details and selects shipping method
    Then User completes the checkout process