package event;

import product.*;

public abstract class Event {
	
	protected ProductDB productDB;
	protected ProductBuy productBuy;
	
	public Event(ProductDB productDB, ProductBuy productBuy) { 
		
		this.productDB = productDB;
		this.productBuy = productBuy;
		
		act();
	}
	
	protected abstract void act();
}