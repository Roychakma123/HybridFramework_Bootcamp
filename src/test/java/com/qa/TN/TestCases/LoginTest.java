package com.qa.TN.TestCases;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.qa.TN.Pages.AccountPage;
	import com.qa.TN.Pages.Homepage;
	import com.qa.TN.Pages.LoginPage;
	import com.qa.TN.Testbase.TestBase;


	public class LoginTest extends TestBase{
		public LoginTest() throws Exception {
		super();
		
	}

		public WebDriver driver;
		public LoginPage loginpage;
		public Homepage  homepage;
		public AccountPage accountpage;


 @BeforeMethod
 	public void setup() {
	driver = InitialiazeBrowserAndOpenApp(prop.getProperty("browser"));
	homepage = new Homepage (driver);
	homepage.clickMyAccountDropdown();
	loginpage = homepage.clickOnLogin();
	
}
  @Test
  	public void verifyLoginWithValidCredentials() {
	  loginpage.enterEmail(prop.getProperty("validEmail"));
	  loginpage.enterPassword(prop.getProperty("validPassword"));
	  accountpage =  loginpage.clickOnLogin();
	
	  Assert.assertTrue(accountpage.displayStatusOfAccountEditInfo());
	
	driver.quit();
	
}
}
