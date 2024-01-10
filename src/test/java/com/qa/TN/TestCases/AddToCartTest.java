package com.qa.TN.TestCases;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.qa.TN.Pages.Homepage;
	import com.qa.TN.Pages.ProductCheckOutPage;
	import com.qa.TN.Pages.ProductInfoPage;
	import com.qa.TN.Pages.SearchPage;
	import com.qa.TN.Testbase.TestBase;

	public class AddToCartTest extends TestBase {

	public AddToCartTest() throws Exception {
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
	public void addingProductsToCart()  {
		homepage.enterProductDetail(dataprop.getProperty("validProduct"));
		searchpage = homepage.clickOnSearch();
		Assert.assertTrue(searchpage.verifyDisplayStatusOfValidProduct());
		productinfopage = searchpage.clickOnAddToCartButton();
		Assert.assertTrue(productinfopage.validateDisplayStatusProdInfo());
		productinfopage.clickOnAddtoCartButton();
		Assert.assertTrue(productinfopage.addToCartsuccessMessage(),dataprop.getProperty("productAddedSuccessfullyToCartMessage"));
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
