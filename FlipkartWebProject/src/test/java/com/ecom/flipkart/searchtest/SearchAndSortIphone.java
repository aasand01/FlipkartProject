package com.ecom.flipkart.searchtest;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ecom.flipkart.genericlib.BaseClass;
import com.ecom.flipkart.genericlib.WebDriverUtils;
import com.ecom.flipkart.objectrepolib.FlipkartHomePage;
import com.ecom.flipkart.objectrepolib.Product;
import com.opencsv.CSVWriter;

/**
 * 
 * @author Shahidha
 * fetch all iphone details -> sort low to high -> filter iphones <40000 -> Sort -> write to csv file
 *
 */
@Listeners(com.extentreport.ItestListenerImpl.class)
public class SearchAndSortIphone extends BaseClass
{

	public static int count;
	@Test
	public void iphonesearchtestcase() throws Throwable
	{
		Product p ;
		WebDriverUtils wdUtils =new WebDriverUtils();
		FlipkartHomePage homePage=new FlipkartHomePage(driver);
		ArrayList<Product> prodList=new ArrayList<Product>();  
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();

		/**
		 * search for iphones and click on low to high filter
		 */
		homePage.getSearchBOX().sendKeys("iphones",Keys.ENTER); 
		homePage.getlowhigh().click();

		wdUtils.waitAndClick(driver, "//a[contains(text(),'iPhone')]");

		/**
		 * fetch iphones details like name, storage , price, ratings
		 */
		List<WebElement> prodlist = homePage.getIphonedevices();
		List<WebElement> pricelist = homePage.getIphonePrice();
		List<WebElement> ratinglist = homePage.getIphoneRatings();
		String[] header = {"Device Details", "Price", "Ratings"};
		List<String[]> list = new ArrayList(); list.add(0,header); 
		
		int numOfProd = prodlist.size();
		System.out.println(numOfProd);
		int i ;
		
		/**
		 * creating iphone Product object with fetched details
		 */
		for( i =0;i<numOfProd-1;i++) {
			String productName = prodlist.get(i).getText();
			String productPrice=pricelist.get(i).getText();
			String productRating=ratinglist.get(i).getText();
			//remove all characters ie sorting out only numbers and remove white spaces in between ( ie convert price rs 13,444 -> 13444 )
			String str = productPrice.replaceAll("[^\\d]", " ");  
			int price  = Integer.parseInt(str.replaceAll("\\s", "")); 
			if(price < 40000) { // sort the iphones less than 40000 and store in a collection
				p= new Product(productName, price ,productRating);
				prodList.add(p);
			}

		}
		/**
		 * sorting the iphone product 
		 */
		Collections.sort(prodList);
		System.out.println(prodList);

		/**
		 * Write the sorted products to csv file
		 */
		Iterator itr=prodList.iterator();  
		while(itr.hasNext()){  
			Product prod=(Product)itr.next();  
			String[] row1 ={prod.getProduct(),String.valueOf(prod.getPrice()),prod.getRatings()}; 
			count++;
			list.add(count, row1); 
		}
		
		CSVWriter writecsv = new CSVWriter(new FileWriter("./Output/Iphonedetails3.csv"));
		writecsv.writeAll(list); 
		writecsv.close();



	}  


}









