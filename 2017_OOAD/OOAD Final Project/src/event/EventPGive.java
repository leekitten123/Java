package event;

import product.ProductBuy;

public class EventPGive extends Event{

	public EventPGive(ProductBuy list) { super(null, list); }
	
	protected void act(){
	
		productBuy.show();
		System.out.println("Give Product to Customer!!!");
		System.out.println("Success!!!");
	}
}
