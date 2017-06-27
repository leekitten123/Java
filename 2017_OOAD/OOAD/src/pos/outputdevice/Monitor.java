package pos.outputdevice;

import java.util.ArrayList;

import pos.type.Product;

/***
 * 
 * 20133243 Lee Sang Wook
 * Monitor.java
 * 
 ***/

public class Monitor extends OutputDevice{

	public String[] menuMain = {"Order", "List", "Pay"};
	public String[] menuHowToOrder = {"Key", "Barcode"};
	public String[] menuHowToPay = {"Card", "Cash"};
	
	public void printProductData(ArrayList<Product> productList) {
		
		System.out.println("***************************");
		
		for (int i = 0 ; i <productList.size() ; i++) {
			System.out.print(i + 1);
			System.out.print(". name : " + productList.get(i).getName());
			System.out.print(" price : " + productList.get(i).getPrice());
			System.out.println();
		}
		
		System.out.println("***************************");
	}
}
