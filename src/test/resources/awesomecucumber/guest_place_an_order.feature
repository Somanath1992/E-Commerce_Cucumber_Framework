Feature: Place an oder
  Scenario: Using default payment option
    Given I'm guest customer
    And my billing details are
      | firstname | lastname | country | address_line1 | city | state | zip | email |
      | demo | user | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | abc@gmail.com|
    And I have a product in the cart
    And I'm on the Checkout page
    When I provide billing details
    And I place an order
    Then Order should be placed successfully
