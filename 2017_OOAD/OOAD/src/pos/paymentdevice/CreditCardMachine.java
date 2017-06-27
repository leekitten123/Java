package pos.paymentdevice;

import pos.payment.Card;

/***
 * 
 * 20133243 Lee Sang Wook
 * CreditCardMachine.java
 * 
 ***/

public class CreditCardMachine extends PaymentDevice{

	public void setPayment(boolean useable, int price) { payment = new Card(useable, price); }
}