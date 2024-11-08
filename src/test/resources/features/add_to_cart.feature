@add_to_cart
Feature: Add item to the cart

  Scenario: User adds an item to the cart from the homepage
    Given User is on the homepage
    When User selects size "L" and color "Gray"
    And the user clicks "Add to Cart"
    Then the item should be added to the cart
