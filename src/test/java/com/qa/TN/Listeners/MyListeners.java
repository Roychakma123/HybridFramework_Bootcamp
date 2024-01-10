package com.qa.TN.Listeners;

	import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.TN.Utilities.ExtentReport;


	public class MyListeners implements ITestListener{
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	public WebDriver driver;
	public String testName;
	
	
	@Override
	public void onStart(ITestContext context) {
		extentReport = new ExtentReports();
		try {
			extentReport = ExtentReport.generateExtentReport();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

	

	@Override
	public void onTestStart(ITestResult result) {
		
	  String testName = result.getName();
	  extentTest = extentReport.createTest(testName);
	  extentTest.log(Status.INFO, testName + "----Test Started");
			  
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		driver =null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch (IllegalArgumentException |IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destinationFile = "C:\\Users\\roly2\\eclipse-workspace\\HybridFramework_Bootcamp\\test-output" + testName + ".png";
	
	try {
		FileHandler.copy(source, new File(destinationFile));
	} catch (IOException e) {
		e.printStackTrace();	
	}
	extentTest.addScreenCaptureFromPath(destinationFile);	
	System.out.println("Screenshot taken");
	System.out.println(result.getThrowable());
	System.out.println(testName + "---> Failed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + "---> Skipped");
		System.out.println(result.getThrowable());
	}

	

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("Project Execution Ends");
		extentReport.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentreport.html";
		File extentReportpath = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReportpath.toURI());
		} catch (IOException e) {
			e.printStackTrace();
	}

	
}
}