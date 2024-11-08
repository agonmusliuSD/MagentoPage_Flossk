@add_remove
Feature: Add and remove item from the cart

  Scenario: User adds an item to the cart and then removes it
    Given User is on the main page of Magento
    When User adds an item to the cart
    Then The item is successfully added to the cart
    When User navigates to the cart
    And User removes the item from the cart
    Then The cart is empty