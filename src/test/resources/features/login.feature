@Functionality
Feature: Swag Labs Login Functionality

  Background:
    Given  User has navigated to the Swag Labs URL
    Given  User verifies login page is displayed

  @TCBT0001
  Scenario Outline: Verify Swag Labs login functionality with valid data
    When User enter valid "<username>" and "<password>"
    And User click the login button for valid data
    Then can see Swag Labs title at the top and in the middle of the page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @TCBT0002
  Scenario Outline: Verify Swag Labs login functionality with invalid data
    When User enter invalid "<username>" and "<password>"
    And User click the login button for invalid data
    Then can see message: Epic sadface: Sorry, this user has been locked out.

    Examples:
      | username        | password     |
      | locked_out_user | secret_sauce |

  @TCBT0003
  Scenario Outline: Verify user problem for Swag Labs login
    When User enter problem "<username>" and "<password>"
    And User click the login button for problem data
    Then the images corresponding to the products cannot be seen

    Examples:
      | username     | password     |
      | problem_user | secret_sauce |


