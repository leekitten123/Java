package pos.paymentdevice;

import pos.payment.Money;

/***
 * 
 * 20133243 Lee Sang Wook
 * MoneyStorageDevice.java
 * 
 ***/

public class MoneyStorageDevice extends PaymentDevice{

	public void setPayment(boolean useable, int price) { payment = new Money(price); }
}