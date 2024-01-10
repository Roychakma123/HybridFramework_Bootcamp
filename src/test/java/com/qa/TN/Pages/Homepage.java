package com.qa.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public WebDriver driver;
	
	@FindBy(linkText="My Account")
	private WebElement myAccountDropdown;
		
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown1;
	
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(xpath = "//input[@class='form-control input-lg']")
	private WebElement searchTextBoxField;
	
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickMyAccountDropdown(){
		myAccountDropdown.click();
		
	}
	public RegisterPage clickOnRegister() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	public LoginPage clickOnLogin() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public void enterProductDetail(String productNameText) {
		searchTextBoxField.sendKeys(productNameText);
	}
	
	public SearchPage clickOnSearch() {
		searchButton.click();
		return new SearchPage(driver);
	}
}
