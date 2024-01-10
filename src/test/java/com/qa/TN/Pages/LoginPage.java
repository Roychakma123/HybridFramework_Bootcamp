package com.qa.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
public WebDriver driver;
	
	@FindBy (id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	public void enterEmail(String emailText) {
		emailAddressField.sendKeys(emailText);
}
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public AccountPage clickOnLogin() {
		loginButton.click();
		return new  AccountPage(driver);
	}
}
