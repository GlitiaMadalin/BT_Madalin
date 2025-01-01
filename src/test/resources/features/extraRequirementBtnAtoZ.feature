@Functionality
Feature: User should be able to analyze the A-Z button functionality

  Background:
    Given  User has navigated to the Swag Labs URL
    Given  User verifies login page is displayed

  @TCBT0001
  Scenario: Login with valid data
    When User enter valid "standard_user" and "secret_sauce" and login
    Then User should see if url contains inventory
    When User analyze A to Z button functionality


