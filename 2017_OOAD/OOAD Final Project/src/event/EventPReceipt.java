package event;

import product.ProductBuy;

public class EventPReceipt extends Event{

	public EventPReceipt(ProductBuy list) { super(null, list); }
	
	protected void act() {
		
		productBuy.show();
		System.out.println("SUM: " + productBuy.productSum());
	}
}
