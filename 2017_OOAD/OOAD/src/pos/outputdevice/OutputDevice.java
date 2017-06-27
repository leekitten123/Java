package pos.outputdevice;

import java.util.ArrayList;

import pos.type.Product;

/***
 * 
 * 20133243 Lee Sang Wook
 * OutputDevice.java
 * 
 ***/

public abstract class OutputDevice{
	
	public void showStr(String str) { System.out.println(str); }
	public void showInt(int num) { System.out.println(num); }
	public void showTotalPrice(int num) { System.out.println("Sum : " + num); }
	public void showChange(int num) {System.out.println("Change : " + num);}
	
	public void showMenu(String[] str) {
		
		System.out.println("***********");

		for (int i = 0 ; i < str.length ; i++) {
			
			System.out.print(i + 1);
			System.out.println(". " + str[i] + " ");
		}
		
		System.out.println("***********");
	}
	
	// Show product information to monitor. The function is determined according to the type.
	public abstract void printProductData(ArrayList<Product> productList);
}
