package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CartHomePage {

	@SuppressWarnings("unused")
	private WebDriver driver;
	
	public CartHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}//End of Constructor
	
	@FindBys(@FindBy(css = "div.product-action button"))
	private List<WebElement> AddtoCartBtns;
	
	public List<WebElement> AddtoCartBtns(){
		return AddtoCartBtns;
	}
	
	
	@FindBy(css="a.cart-icon img")
	private WebElement CartBtn;
	
	
	public WebElement CartBtn() {
		return CartBtn;
	}//End of CartBtn
	
	@FindBys(@FindBy(css="p.product-name"))
	private List<WebElement> ItemNameInCart;
	
	public List<WebElement> ItemNameInCart() {
		return ItemNameInCart;
	}//end of ItemNameInCart
	
	
	@FindBys(@FindBy(css="h4.product-name"))
	private List<WebElement> ProductName;
	
	public List<WebElement> ProductName(){
		return ProductName;
	}//End of ProductName
	
	
	@FindBy(xpath= "//div[@class='action-block']/button[contains(text(),'PROCEED TO CHECKOUT')]")
	private WebElement PrcdChkOutBtn;
	
	public WebElement PrcdChkOutBtn() {
		return PrcdChkOutBtn;
	}
	
	
}//End of CartHomePage
