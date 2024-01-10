package com.qa.TN.Testbase;



	import java.io.FileInputStream;
	import java.time.Duration;
	import java.util.Properties;

	import org.openqa.selenium.PageLoadStrategy;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

	public class TestBase {
	
	public WebDriver driver;
	public ChromeOptions options;
	public Properties prop; 
	public FileInputStream ip ;
	public FileInputStream ip1;
	public Properties dataprop;
   
	
	public TestBase() throws Exception {
		 prop = new Properties();
		 ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\qa\\TN\\Config\\config.properties");
		 prop.load(ip);
	
		 
		 dataprop = new Properties();
		 ip1 = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\qa\\TN\\Testdata\\dataProp.properties"); 
		 dataprop.load(ip1);
	
	}
	public WebDriver InitialiazeBrowserAndOpenApp(String browserName) {
		
		
		options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		
		driver=new ChromeDriver(options);
	    driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
		
		
		
		return driver;
	}
}