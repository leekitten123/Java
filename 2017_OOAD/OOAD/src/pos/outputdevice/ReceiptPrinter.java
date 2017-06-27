package pos.outputdevice;

import java.util.ArrayList;

import pos.type.Product;

/***
 * 
 * 20133243 Lee Sang Wook
 * ReceiptPrinter.java
 * 
 ***/

public class ReceiptPrinter extends OutputDevice{
	
	public void printProductData(ArrayList<Product> productList) {
		
		for (int i = 0 ; i <productList.size() ; i++) {
			System.out.print(i + 1);
			System.out.print(". name : " + productList.get(i).getName());
			System.out.print(" price : " + productList.get(i).getPrice());
			System.out.println();
		}
	}
}
