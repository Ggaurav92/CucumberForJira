$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AddtoCart.feature");
formatter.feature({
  "name": "Cart",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add a product to cart",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on HomePage using the url \"https://rahulshettyacademy.com/seleniumPractise/#/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.stepDefinitions.CartStepDefinition.i_am_on_HomePage_using_the_url(java.lang.String)"
});
formatter.embedding("image/png", "embedded0.png", "Screenshot");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "0 Given");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I click add button under a product",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepDefinitions.CartStepDefinition.i_click_add_button_under_a_product()"
});
formatter.embedding("image/png", "embedded2.png", "Screenshot");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png", "1 When ");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I click on cart icon",
  "keyword": "And "
});
formatter.match({
  "location": "com.stepDefinitions.CartStepDefinition.i_click_on_cart_icon()"
});
formatter.embedding("image/png", "embedded4.png", "Screenshot");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded5.png", "2 And  ");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I can see the product added to cart",
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepDefinitions.CartStepDefinition.i_can_see_the_product_added_to_cart()"
});
formatter.embedding("image/png", "embedded6.png", "Screenshot");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded7.png", "3 Then ");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Add multiple products to cart",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on HomePage using the url \"https://rahulshettyacademy.com/seleniumPractise/#/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.stepDefinitions.CartStepDefinition.i_am_on_HomePage_using_the_url(java.lang.String)"
});
formatter.embedding("image/png", "embedded8.png", "Screenshot");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded9.png", "0 Given");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I add the first four products in list",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepDefinitions.CartStepDefinition.i_add_the_first_four_products_in_list()"
});
formatter.embedding("image/png", "embedded10.png", "Screenshot");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded11.png", "1 When ");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I click on cart icon",
  "keyword": "And "
});
formatter.match({
  "location": "com.stepDefinitions.CartStepDefinition.i_click_on_cart_icon()"
});
formatter.embedding("image/png", "embedded12.png", "Screenshot");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded13.png", "2 And  ");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I click on Proceed to Checkout Button",
  "keyword": "When "
});
formatter.match({
  "location": "com.stepDefinitions.CartStepDefinition.i_click_on_proceed_to_checkout_button()"
});
formatter.embedding("image/png", "embedded14.png", "Screenshot");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded15.png", "3 When ");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "the following items are added to the the cart",
  "rows": [
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.stepDefinitions.CartStepDefinition.the_following_items_are_added_to_the_the_cart(io.cucumber.datatable.DataTable)"
});
formatter.embedding("image/png", "embedded16.png", "Screenshot");
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded17.png", "4 Then ");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});