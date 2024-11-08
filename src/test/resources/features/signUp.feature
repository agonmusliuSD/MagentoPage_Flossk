@sign_up
Feature: Sign up for a new account

  Scenario: User successfully signs up
    Given User is on the Magento homepage
    When User navigates to the Sign Up page
    And User enters their sign-up information
    And User submits the form
    Then User should see a confirmation message for account creation