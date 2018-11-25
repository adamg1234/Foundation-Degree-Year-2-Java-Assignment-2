package partA;

import partB.BookingException;

public class Product implements java.io.Serializable 
{
	private String productID,  manufacturer,  name, category;
	private int noSold,  noInStock;
	private double  cost, sellingPrice;
	
	public Product()
	{
		this.productID="";
		this.manufacturer="";
		this.name= "";
		this.category= "";
		this.noSold=0;
		this.noInStock=0;
		this.cost=0;
		this.sellingPrice=0;
	}
	
	public Product(String productID, String manufacturer, String name, String category, int noSold,int noInStock, 
			double cost, double sellingPrice)
	{
		this.productID=productID;
		this.manufacturer=manufacturer;
		this.name=name;
		this.category=category;
		this.noSold=noSold;
		this.noInStock=noInStock;
		this.cost=cost;
		this.sellingPrice=sellingPrice;
	}
	
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) throws ProductException
	{
		if (productID.length() < 3 || productID.length()>15)
			throw new ProductException("Must Enter a Product ID (3-25 characters)");
		else
			this.productID = productID;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) throws ProductException
	{
		if (manufacturer.length() < 1 || manufacturer.length()>=20)
			throw new ProductException("Must Enter a Manufacturer (1-20 characters)");
		else
			this.manufacturer = manufacturer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws ProductException
	{
		if (name.length() < 3 || name.length()>=25)
			throw new ProductException("Must Enter a Name (3-25 characters)");
		else
			this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNoSold() {
		return noSold;
	}
	public void setNoSold(int noSold)
	{
		this.noSold = noSold;
	}
	public int getNoInStock() {
		return noInStock;
	}
	public void setNoInStock(int noInStock)throws ProductException
	{
		if (noInStock < 1)
			throw new ProductException("Must Enter a Stock No (More than 1)");
		else
			this.noInStock = noInStock;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) throws ProductException
	{
		if (cost < 0.0)
			throw new ProductException("Must Enter a Cost (More than 0.0)");
		else
			this.cost = cost;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) throws ProductException
	{
		if (sellingPrice < 0.0)
			throw new ProductException("Must Enter a Stock No (More than 1)");
		else
			this.sellingPrice = sellingPrice;
	}
	@Override
	public String toString() {
		
		String str="";
		
		str = String.format("%-15s  %-20s   %-20s %-20s  %-10d %-10d  %-10.2f  %-10.2f\n", this.productID,this.manufacturer,
				this.name,this.category,this.noSold,this.noInStock,this.cost,this.sellingPrice);
		
		return str;
		
	}
	
	

}
