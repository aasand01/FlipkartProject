package com.ecom.flipkart.objectrepolib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Shahidha
 * Object repository for flipkart home page
 */
public class FlipkartHomePage {

	@FindBy(name="q")
	private WebElement searchBOX;

	@FindBy(xpath="//a[contains(text(),'iPhone')]")
	private List<WebElement> Iphonedevices;

	@FindBy(xpath="//a[contains(text(),'iPhone')]/..//div[@class='_30jeq3']")
	private List<WebElement> IphonePrice;

	//@FindBy(xpath="//a[contains(text(),'iPhone')]/..//div[@class='_3LWZlK']")
	@FindBy(xpath="//a[contains(text(),'iPhone')]/..//span[@class='_2_R_DZ']")
	private List<WebElement> IphoneRatings;

	@FindBy(xpath="//div[.='Price -- Low to High']")
	private WebElement lowhigh;

	public WebElement getSearchBOX() {
		return searchBOX;
	}

	public WebElement getlowhigh() {
		return lowhigh;
	}

	public List<WebElement> getIphonedevices() {
		return Iphonedevices;
	}

	public List<WebElement> getIphoneRatings() {
		return IphoneRatings;
	}

	public List<WebElement> getIphonePrice() {
		return IphonePrice;
	}

	public FlipkartHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}


}
