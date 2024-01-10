package com.qa.TN.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TN.Pages.Homepage;
import com.qa.TN.Pages.SearchPage;
import com.qa.TN.Testbase.TestBase;

public class SearchProductTest extends TestBase{

	public SearchProductTest() throws Exception {
		super();
		
	}
	
	public WebDriver driver;
	public Homepage homepage;
	public SearchPage searchpage;
	
	@BeforeMethod
	public void setup() {
		driver = InitialiazeBrowserAndOpenApp(prop.getProperty("browser"));
	}
	@Test
	public void SearchWithValidProduct() {
		homepage = new Homepage(driver);
		homepage.enterProductDetail(dataprop.getProperty("validProduct"));
		searchpage = homepage.clickOnSearch();
	    Assert.assertTrue(searchpage.verifyDisplayStatusOfValidProduct()); 
	    
	    driver.quit();
}
}
