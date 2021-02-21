package com.extentreport;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ItestListenerImpl implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		//WebDriver driver = null;
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		Date date=new Date();
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(new File("./ExtentReport.html"));
		htmlReporter.config().setDocumentTitle("Flipkart App");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Smoke test");
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Test url", "https://www.flipkart.com");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Reporter Name", "Shahidha");
		reports.setSystemInfo("BrowserName", "Chrome");
		reports.setSystemInfo("Browser version", "87");
		
	}

	public void onFinish(ITestContext context) {
		reports.flush();
		
	}

}