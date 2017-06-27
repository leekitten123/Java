package pos.payment;

/***
 * 
 * 20133243 Lee Sang Wook
 * Payment.java
 * 
 ***/

public abstract class Payment {

	private boolean useable;
	private int price;
	
	// Type of payment method
	public Payment(boolean useable, int price) {
		
		setUseable(useable);
		setPrice(price);
	}
	
	public void setPrice(int price) { this.price = price; }
	public void setUseable(boolean useable) { this.useable = useable; }
	
	public int getPrice() { return price; } 
	public boolean isUseable() { return useable; }
}