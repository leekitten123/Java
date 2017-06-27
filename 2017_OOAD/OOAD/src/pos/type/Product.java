package pos.type;

/***
 * 
 * 20133243 Lee Sang Wook
 * Product.java
 * 
 ***/

public class Product {

	private String name;
	private int price;
	
	public Product(String name, int price) { setName(name); setPrice(price); }
	
	public String getName() { return this.name; }
	public int getPrice() { return this.price; }
	
	public void setName(String name) { this.name = name; }
	public void setPrice(int price) { this.price = price; }
}