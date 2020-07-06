package com.stepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.enums.Browsers;
import com.pageObjects.CartHomePage;
import com.testBase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefinition extends TestBase{

	TestBase testbase;
	CartHomePage CHP;
	Logger log = LogManager.getLogger(this.getClass().getName());
	
	@Given("I am on HomePage using the url {string}")
	public void i_am_on_HomePage_using_the_url(String url) {
		testbase = new TestBase();
		testbase.selectBrowser(Browsers.CHROME.name());
		log.info("Driver initiated");
		
		CHP = new CartHomePage(driver);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		ServiceHooks.TakeScreenshot("Screenshot");
		log.info("HomePage Opened Successfully");
		
	}

	@When("I click add button under a product")
	public void i_click_add_button_under_a_product() {
	    
		
		
		CHP.AddtoCartBtns().get(0).click();
		ServiceHooks.TakeScreenshot("Screenshot");
	}

	@When("I click on cart icon")
	public void i_click_on_cart_icon() {
	    
		CHP.CartBtn().click();
		ServiceHooks.TakeScreenshot("Screenshot");
	}

	@Then("I can see the product added to cart")
	public void i_can_see_the_product_added_to_cart() {
	    
		CHP.ItemNameInCart().get(0).isDisplayed();
		ServiceHooks.TakeScreenshot("Screenshot");
	}
	
	
	@When("I add the first four products in list")
    public void i_add_the_first_four_products_in_list() throws Throwable {
        
		CHP.AddtoCartBtns().get(0).click();
		CHP.AddtoCartBtns().get(1).click();
		CHP.AddtoCartBtns().get(2).click();
		CHP.AddtoCartBtns().get(3).click();
		ServiceHooks.TakeScreenshot("Screenshot");
	}
	
	@When("I click on Proceed to Checkout Button")
    public void i_click_on_proceed_to_checkout_button() throws Throwable {
        
		CHP.PrcdChkOutBtn().click();
		ServiceHooks.TakeScreenshot("Screenshot");
    }
	
	@Then("the following items are added to the the cart")
    public void the_following_items_are_added_to_the_the_cart(DataTable data) throws Throwable {
        
		List<List<String>> obj = data.asLists();
		
		//List<String> ExpectedProductName = new ArrayList<String>(Arrays.asList(obj.get(0).get(0),obj.get(0).get(1),obj.get(0).get(2),obj.get(0).get(0)));

		List<String> ExpectedProductName = new ArrayList<String>();
		
		for (int i = 0; i < 4; i++) {
			ExpectedProductName.add(obj.get(0).get(i).replace("_", " "));
			System.out.println("The Expected Product Name is " + obj.get(0).get(i).replace("_", " "));
		}
		//CHP.CartBtn().click();
		
		for (int i = 0; i < ExpectedProductName.size(); i++) {
			System.out.println(CHP.ItemNameInCart().get(i).getText());
			System.out.println(ExpectedProductName.get(i));
			
			Assert.assertEquals(CHP.ItemNameInCart().get(i).getText(), ExpectedProductName.get(i));
		}
		
		ServiceHooks.TakeScreenshot("Screenshot");
    }
	
	
}//End of Class
