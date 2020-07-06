Feature: Cart

@Smoke
Scenario: Add a product to cart
Given I am on HomePage using the url "https://rahulshettyacademy.com/seleniumPractise/#/"
When I click add button under a product 
And I click on cart icon 
Then I can see the product added to cart 



@Smoke
Scenario: Add multiple products to cart
Given I am on HomePage using the url "https://rahulshettyacademy.com/seleniumPractise/#/"
When I add the first four products in list
And I click on cart icon
When I click on Proceed to Checkout Button
Then the following items are added to the the cart
|Brocolli_-_1_Kg|Cauliflower_-_1_Kg|Cucumber_-_1_Kg|Beetroot_-_1_Kg|


