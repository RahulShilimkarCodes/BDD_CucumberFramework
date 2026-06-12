Feature: Search and place the order on Greenkart application

@SingleRun
Scenario: Search experience for product on both Home Page and Offer Page

Given User is on GreenKart Landing Page
When User searches for product with ShortName as Tom on HomePage
And User Extracts the actual name of product
And User navigates to Offers Page
Then User searches for same product using same ShortName as Tom on OffersPage
And checks if product exists under Offers Page too



@DataDriven
Scenario Outline: Search experience for product on both Home Page and Offer Page

Given User is on GreenKart Landing Page
When User searches for product with ShortName as <ProductName> on HomePage
And User Extracts the actual name of product
And User navigates to Offers Page
Then User searches for same product using same ShortName as <ProductName> on OffersPage
And checks if product exists under Offers Page too

Examples:
|ProductName|
|Tom|
|Beet|
|Brocolli|
|Strawberry|