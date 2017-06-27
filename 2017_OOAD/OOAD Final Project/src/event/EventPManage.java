package event;
import java.util.Scanner;

import product.Product;
import product.ProductDB;

public class EventPManage extends Event{
	
	public EventPManage(ProductDB list) { super(list, null); }
	
	protected void act() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("<<< Add or Delete >>>");
		
		String str = scanner.next();
		
		if (str.equals("Add")) {

			productDB.add(new Product(scanner.next(), scanner.nextInt()));
			
		} else if (str.equals("Delete")) {

			productDB.delete(new Product(scanner.next(), scanner.nextInt()));
		}
	}
}
