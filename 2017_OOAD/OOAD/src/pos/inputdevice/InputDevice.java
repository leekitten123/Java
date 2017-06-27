package pos.inputdevice;

import java.util.Scanner;

import pos.type.Input;

/***
 * 
 * 20133243 Lee Sang Wook
 * InputDevice.java
 * 
 ***/

import pos.type.Product;

public abstract class InputDevice {
	
	protected Scanner scanner = new Scanner(System.in);
	
	private Product product;
	private Input input;
	
	public Product getProduct() { return this.product; }
	public Input getInput() { return this.input; }
	
	public void setProduct(Product product) { this.product = product; }
	public void setInput(Input input) { this.input = input; }
	
	// Scan product name or barcode and then change them to product information
	public void activate() {
		 
		scanProduct();
		setProduct(toProduct());
	}
	
	public String scanStr() { return scanner.next(); }
	public int scanInt() { return scanner.nextInt(); }
	
	public abstract void scanProduct();
	
	public Product toProduct() {
		
		if ((input.getDataNum1() == 0 && input.getDataNum2() == 0) || (input.getDataName().equals("Rice"))) {
			return new Product("Rice", 1000);
		} else if ((input.getDataNum1() == 0 && input.getDataNum2() == 1) || (input.getDataName().equals("Noodle"))) {
			return new Product("Noodle", 2000);
		} else if ((input.getDataNum1() == 1 && input.getDataNum2() == 0) || (input.getDataName().equals("Snack"))) {
			return new Product("Snack", 3000);
		} else if ((input.getDataNum1() == 1 && input.getDataNum2() == 1) || (input.getDataName().equals("Water"))) {
			return new Product("Water", 4000);
		} else {
			return new Product("-1", -1);
		}
	}
}