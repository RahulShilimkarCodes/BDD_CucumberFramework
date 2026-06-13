Feature: Placing the order of the product

  @EndToEnd
  Scenario Outline: End to End product buying script
    Given User is on GreenKart Landing Page
    When User searches for product with ShortName as <ProductName> on HomePage
    And User Extracts the actual name of product
    And User adds <quantity> quantity for the product
    And user proceeds to checkout page
    And User validates the item in checkout page
    Then User enters the promo code as rahulshettyacademy
    And user verifies successful promoCode application
    And User places the order
    And User selects country as <Country>

    Examples: 
      | ProductName | quantity | Country       |  
      | Strawberry  |        3 | India         |  
      | Beetroot    |        2 | Australia     |  
      | Brocolli    |        5 | United States |  
