@reset_password
Feature: Reset Password

  Scenario: User resets their password
    Given User is on the login page of Magento
    When User clicks "Forgot Your Password?"
    And User enters their email address
    And User submits the reset password request
    Then User sees a password reset confirmation message