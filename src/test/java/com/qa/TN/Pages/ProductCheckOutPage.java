package com.qa.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCheckOutPage {
	
public WebDriver driver;
	
	@FindBy(xpath= "//span[contains(text(),'Checkout')]")
	private WebElement clickCheckOut;
	
	@FindBy(id = "input-email")
	private WebElement enterEmailAddress;	
	
	@FindBy(id = "input-password")
	private WebElement enterPassword;
	
	@FindBy(id = "button-login")
	private WebElement ClickOnLogin;
	
	@FindBy (xpath = "//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[3]/label[1]/input[1]")
	private WebElement useANewaddressButton;
	
	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	private WebElement enterFirstName;
	
	@FindBy(id = "input-payment-lastname")
	private WebElement enterlastname;
	
	@FindBy(id = "input-payment-address-1")
	private WebElement enterAddress1;
	
	@FindBy(id = "input-payment-city")
	private WebElement enterCity;
	
	@FindBy(id = "input-payment-postcode")
	private WebElement enterPostCode;
	
	
	
	@FindBy(id = "button-payment-address")
	private WebElement clickOnOnContinueAddress;
	
	@FindBy(id = "button-shipping-address")
	private WebElement clcikOnContinueButtonShipping;
	
	@FindBy(id = "button-shipping-method")
	private WebElement clcikOnContinueButtonShippingMethod;
	

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement termsAndCondition;
	
	@FindBy(xpath = "//input[@id='button-payment-method']")
	private WebElement clickOnContinueButtonPaymentMethod;
	
	@FindBy(xpath = "//input[@id='button-confirm']")
	private WebElement clickOnConfirmOrder;
	
	@FindBy(xpath = "//h1[contains(text(),'Your order has been placed!')]")
	private WebElement orderPlacedmessage;
	
	
	
	
   public ProductCheckOutPage(WebDriver driver) {
	   this.driver= driver;
	   PageFactory.initElements(driver, this);
	   
	}
	public void clickOnCheckout() { 
		 clickCheckOut.click();
		
	}
	public void emailfield(String emailtext) {
		enterEmailAddress.sendKeys(emailtext);
	}
	public void passwordField(String passwordtext) {
		enterPassword.sendKeys(passwordtext);
	}
	public void loginButton() {
		ClickOnLogin.click();
	}
	public void newAddressRadioButton() {
		useANewaddressButton.click();
	}
	public void firstNamefield(String firstnametext) {
		enterFirstName.sendKeys(firstnametext);
		
	}
	public void lastNameField(String lastnametext) {
		enterlastname.sendKeys(lastnametext);
		
	}
	public void addressfield(String addresstext) {
		enterAddress1.sendKeys(addresstext);
	}
	public void cityField(String citytext) {
		enterCity.sendKeys(citytext);
	}
	public void postcodeField(String postcodetext) {
		enterPostCode.sendKeys(postcodetext);
		
	}
	public void selectCountry(String countrytext) {
	
	}
	
	
	public void continueButtonAddress() {
		clickOnOnContinueAddress.click();
	}
	public void continueButtonShipping() {
		clcikOnContinueButtonShipping.click();
	}
	public void continueButtonShippingmethod() {
		clcikOnContinueButtonShippingMethod.click();
	}
	public void termsAndConditionButton() {
		termsAndCondition.click();
	}
	public void continueButtonPaymentMethod() {
		clickOnContinueButtonPaymentMethod.click();
	}
	public void confirmOrder() {
		clickOnConfirmOrder.click();
	}
	public boolean orderSucessMessage() {
		 return orderPlacedmessage.isDisplayed();
		
		 
		

}
}
