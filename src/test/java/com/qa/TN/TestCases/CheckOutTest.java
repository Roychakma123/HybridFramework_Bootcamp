package com.qa.TN.TestCases;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.qa.TN.Testbase.TestBase;
	import com.qa.TN.Pages.Homepage;
	import com.qa.TN.Pages.ProductCheckOutPage;
	import com.qa.TN.Pages.ProductInfoPage;
	import com.qa.TN.Pages.SearchPage;

	public class CheckOutTest extends TestBase{

	
	public CheckOutTest() throws Exception {
		super();
		
	}
	public WebDriver driver;
	public Homepage homepage;
	public SearchPage searchpage;
	public ProductInfoPage productinfopage;
	public ProductCheckOutPage productcheckoutpage;

	
	@BeforeMethod
	public void setup() {
		driver = InitialiazeBrowserAndOpenApp(prop.getProperty("browser"));
		homepage= new Homepage(driver);
		searchpage = new SearchPage(driver); 
		productcheckoutpage = new ProductCheckOutPage(driver);
		
		
	}
	
	@Test
	public void checkoutProduct()  {
		homepage.enterProductDetail(dataprop.getProperty("validProduct"));
		searchpage = homepage.clickOnSearch();
		productinfopage = searchpage.clickOnAddToCartButton();
		productinfopage.clickOnAddtoCartButton();
		Assert.assertTrue(productinfopage.addToCartsuccessMessage(),dataprop.getProperty("productAddedSuccessfullyToCartMessage"));
		productcheckoutpage = productinfopage.clickOnCheckOut();
		productcheckoutpage.emailfield(prop.getProperty("validEmail"));
		productcheckoutpage.passwordField(prop.getProperty("validPassword"));
		productcheckoutpage.loginButton();
		productcheckoutpage.newAddressRadioButton();
		productcheckoutpage.firstNamefield(dataprop.getProperty("firstName"));
		productcheckoutpage.lastNameField(dataprop.getProperty("lastName"));
		productcheckoutpage.addressfield(prop.getProperty("Address"));
		productcheckoutpage.cityField(prop.getProperty("city"));
		productcheckoutpage.postcodeField(prop.getProperty("PostCode"));
		
		Select select = new Select(driver.findElement(By.id("input-payment-country")));
    	select.selectByVisibleText("United States");
    	
    	Select select1 = new Select(driver.findElement(By.xpath("//select[@id='input-payment-zone']")));
    	select1.selectByVisibleText("Pennsylvania");
    	
    	productcheckoutpage.continueButtonAddress();
    	productcheckoutpage.continueButtonShipping();
    	productcheckoutpage.continueButtonShippingmethod();
    	productcheckoutpage.termsAndConditionButton();
    	productcheckoutpage.continueButtonPaymentMethod();
    	productcheckoutpage.confirmOrder();
    	Assert.assertTrue(productcheckoutpage.orderSucessMessage(),dataprop.getProperty("orderPlacedMessage"));
    	
    	
		
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
