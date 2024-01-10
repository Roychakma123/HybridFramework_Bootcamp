package com.qa.TN.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage {
	
public WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement newsLetterRadioButton;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	public RegisterPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterFirstname(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	public void enterTelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
		
	}
	public void clickOnPrivacycheckbox() {
		privacyPolicyCheckBox.click();
	}
	public void clickOnNewsLetterButton() {
		newsLetterRadioButton.click();
	}
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.submit();
		return new AccountSuccessPage (driver);
		
	}
	
}