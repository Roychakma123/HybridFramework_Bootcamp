package com.qa.TN.TestCases;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.qa.TN.Pages.AccountPage;
	import com.qa.TN.Pages.AccountSuccessPage;

	import com.qa.TN.Pages.Homepage;
	import com.qa.TN.Pages.RegisterPage;
	import com.qa.TN.Testbase.TestBase;
	import com.qa.TN.Utilities.Util;


	public class RegisterTest extends TestBase{

	public RegisterTest() throws Exception {
		super();
		
	}
	public WebDriver driver;
	public Homepage homepage;
	public RegisterPage registerpage;
	public AccountSuccessPage accountsucesspage;
	public AccountPage accountpage;
	
	@BeforeMethod
	public void setup() {
		driver = InitialiazeBrowserAndOpenApp("browser");
		homepage = new Homepage(driver);
		homepage.clickMyAccountDropdown();
		registerpage = homepage.clickOnRegister();
		
	}
	@Test 
	public void verifyRegisterWithAllFields() {
		
		registerpage.enterFirstname(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(Util.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataprop.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("validPassword"));
	    registerpage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerpage.clickOnNewsLetterButton();
		registerpage.clickOnPrivacycheckbox();
        accountsucesspage = registerpage.clickOnContinueButton();
        
      
		Assert.assertEquals(accountsucesspage.retrieveAccountSuccessMessage(),dataprop.getProperty("accountSuccessMessage"));
		
		driver.quit();

}
}
