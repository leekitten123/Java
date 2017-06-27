package pos.paymentdevice;

import pos.payment.Payment;

/***
 * 
 * 20133243 Lee Sang Wook
 * PaymentDevice.java
 * 
 ***/

public abstract class PaymentDevice{

	protected Payment payment;
	
	public Payment getPayment() { return payment; }

	public abstract void setPayment(boolean useable, int price);
}