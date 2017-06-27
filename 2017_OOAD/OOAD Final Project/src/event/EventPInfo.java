package event;

import product.ProductBuy;

public class EventPInfo extends Event{
	
	public EventPInfo(ProductBuy list) { super(null, list); }
	
	protected void act(){ productBuy.show(); }
}
