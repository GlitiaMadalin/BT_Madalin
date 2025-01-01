@Functionality
Feature:

  Background:
    Given  User has navigated to the Swag Labs URL
    Given  User verifies login page is displayed

  @TCBT0001
  Scenario Outline: Add one product to cart page
    When User enter the valid "<username>" and "<password>"
    And User click on the login button with valids data
    Then can see Swag Labs title at the top in the middle of the page
    When User click on the Add to Cart button
    Then User must see the product added in the Cart and the related specifications
    When User click on the cart icon
    Then User can see cart page
    And can see specifications related with the product added last time,about: name product,specifications,price
    When User click on checkout button
    And verifies Checkout: Your Information is displayed
    And will verify all boxes on the page and fill with data
    And click on Continue button
    And verifies checkoutPageHeader is displayed
    And click on Finish button
    Then checkOut Complete page wil be displayed
    And  a succes message will be displayed
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @TCBT0002
  Scenario Outline: Delete one product from the cart
    When User enter the valid "<username>" and "<password>"
    And User click on the login button with valids data
    Then can see Swag Labs title at the top in the middle of the page
    When User click on the Add to Cart button
    Then User must see the product added in the Cart and the related specifications
    When User click on the cart icon
    Then User can see cart page
    And can see specifications related with the product added last time,about: name product,specifications,price
    When User delete the product from the cart
    When User click on the cart icon
    Then can t see no one product in the cart
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @TCBT0003
  Scenario Outline: Can add more products to the cart
    When User enter a valid "<username>" and "<password>"
    And User click on the login button with valid data
    Then can see Swag Labs title at the top in the middle of the page
    When User click on the Add to Cart button
    Then User must see the product added in the Cart and the related specifications
    When  User click another Add to Cart button
    Then must see another added product added and it s related specifications
    When User click the cart icon
    Then User will be transferred to the cart page
    And User can see two products and the related specifications of latest added product and bag specifications
    And User can see two products and the related specifications of latest added product and bike specifications
    When User delete second product from cart
    And User delete first product from cart
    Then User can t see product in the cart
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |


