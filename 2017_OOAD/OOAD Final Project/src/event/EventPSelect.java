package event;
import java.util.Scanner;

import product.ProductBuy;
import product.ProductDB;


public class EventPSelect extends Event{

	public EventPSelect(ProductDB list1, ProductBuy list2) { super(list1, list2); }
	
	protected void act() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("<<< Add or Delete >>>");
		
		String str = scanner.next();
		
		if (str.equals("Add")) {

			String name = scanner.next();
			
			if (productDB.find(name)) {
				productBuy.add(productDB.getProduct(name));
			}
			
			
		} else if (str.equals("Delete")) {
			
			String name = scanner.next();
			
			if (productBuy.find(name)) {
				productBuy.delete(productBuy.getProduct(name));
			}
		}
	}
}
