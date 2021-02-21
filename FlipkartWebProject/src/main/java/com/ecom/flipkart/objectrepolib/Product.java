package com.ecom.flipkart.objectrepolib;

/**
 * 
 * @author Shahidha
 * This class contains contructor to create product
 * and also contains sorting functionality
 *
 */
public class Product implements Comparable<Product>{
	String productName;
	int Price;
	String Ratings;

	public String getProduct() {
		return productName;
	}

	public void setProduct(String product) {
		this.productName = product;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getRatings() {
		return Ratings;
	}

	public void setRatings(String ratings) {
		Ratings = ratings;
	}

	public Product(String product, int Price, String Ratings) {
		this.productName=product;
		this.Price=Price;
		this.Ratings=Ratings;

	}

	public String toString(){//overriding the toString() method  
		return productName+" "+Price+" "+Ratings;  
	}

	public int compareTo(Product p) {
		if(Price==p.Price)  
			return 0;  
		else if(Price > p.Price)  
			return 1;  
		else  
			return -1;  
	}  
}  



