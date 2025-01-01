@Functionality
Feature: Swag Labs Hamburger Menu Functionality

  Background:
    Given  User has navigated to the Swag Labs URL
    Given  User verifies login page is displayed
    When User enter valid username
    And User enter valid password
    And User click on the login button

  @TCBT0001
  Scenario: User log in to Swag home Labs page
    Then User should verify the home page title

  @TCBT0002
  Scenario: User check Hamburger Menu functionality
    When User click on the Hamburger Menu button
    Then can see Hamburger menu
    When User click on X button
    Then can t see Hamburger menu

  @TCBT0003
  Scenario: User check All Items links from Hamburger Menu section
    When User click on Hamburger Menu button
    Then can see All Items link
    When User click on the All Items links
    Then User can see Swag Labs

  @TCBT0004
  Scenario: User check About links from Hamburger Menu section
    When User click on Hamburger Menu button
    Then can see About link
    When User click on the About links
    Then User can see SauceLabs

  @TCBT0005
  Scenario: User logout from Swag Labs page
    When User click on Hamburger Menu button
    Then can see Logout link
    When User click on the Logout link
    Then User can see Swag Labs title

  @TCBT0006
  Scenario: User click on Reset App State link from Hamburger Menu section
    When User click on Hamburger Menu button
    Then can see Reset App State
    When User click on the Reset App State
    Then User can see cart has no one product



