Feature: Add a review to an item

  Scenario: User adds a review to an item from the item page
    Given User is on the item page
    When User clicks "Add Your Review"
    When User enters a review with nickname "Agon" and title "Great Product!" and body "This product exceeded my expectations!"
    And User selects a rating of "5 stars"
    Then User submits the review
