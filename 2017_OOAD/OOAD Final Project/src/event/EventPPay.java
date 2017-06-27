package event;
import java.util.Scanner;

import payment.Payment;
import payment.PaymentCard;
import payment.PaymentCash;
import product.ProductBuy;

public class EventPPay extends Event{

	Payment payment;
	
	public EventPPay(ProductBuy list) { super(null, list); }
	
	protected void act() {
		
		int sum = productBuy.productSum();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("<<< Cash or Card >>>");
		
		String str = scanner.next();
		
		if (str.equals("Cash")) {
			
			payment = new PaymentCard(10000);
			
		} else if (str.equals("Card")) {
			
			payment = new PaymentCash(10000);
		}
		
		System.out.println("SUM: " + sum);
		
		if (sum <= payment.getMoney()) {
			
			System.out.println("Success!!!");
			
		} else {
			
			System.out.println("Fail!!!");
		}	
	}
}
