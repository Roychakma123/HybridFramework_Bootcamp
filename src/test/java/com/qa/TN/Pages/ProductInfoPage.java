package com.qa.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
public WebDriver driver;
	
	@FindBy(xpath = "//li[contains(text(), 'Product Code:Product 21')]")
	private WebElement ProductCodeInfo;
	
	@FindBy(id = "button-cart")
	private WebElement addToCartButtonInProductInfoPage;
	
	@FindBy(linkText = "Checkout")
	private WebElement checkOutBox;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement addToCartSuccessMessage;
	
	
	
	public ProductInfoPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public boolean validateDisplayStatusProdInfo() {
		return ProductCodeInfo.isDisplayed();
		
	}
	
	public void clickOnAddtoCartButton() {
		addToCartButtonInProductInfoPage.click();
	}
	public ProductCheckOutPage clickOnCheckOut(){
		checkOutBox.click();
		return new ProductCheckOutPage(driver);
		
	}
	public boolean addToCartsuccessMessage() {
	 return addToCartSuccessMessage.isDisplayed();
	
	}
}
