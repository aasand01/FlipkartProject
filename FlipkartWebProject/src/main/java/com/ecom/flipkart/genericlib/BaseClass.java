package com.ecom.flipkart.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * 
 * @author Shahidha
 * contains common annotations which is used by all the test class.
 * here we usually have common code for opening and closing browser / login and logout application
 */
public class BaseClass 
{
	public FileUtility fLib = new FileUtility();
	public static WebDriver driver;
	public WebDriverUtils wLib = new WebDriverUtils();

	@BeforeSuite
	public void configBS() {

	}

	@BeforeTest
	public void configBT() {

	}
	@BeforeClass()
	public void configBC() throws Throwable {

		String URL  = fLib.getPropertyKeyValue("url");

		String BROWSER  = fLib.getPropertyKeyValue("browser");

		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}else {
			driver = new ChromeDriver(); 
		}
		driver.manage().window().maximize();
		wLib.waitForHTMLDOM(driver);
		driver.get(URL);
	}

	//@BeforeMethod(groups={"smokeTest","regressionTest"})
	@BeforeMethod
	public void configBM() throws Throwable {
	}

	//@AfterMethod(groups={"smokeTest","regressionTest"})
	@AfterMethod
	public void configAM() {

	}

	@AfterClass
	public void configAC() {
		driver.quit();
	}

	@AfterTest
	public void configAT() {

	}

	@AfterSuite
	public void configAS() {

	}

}