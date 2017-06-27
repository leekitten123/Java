package actor;
import pos.MainSystem;

public class Customer extends Actor{
	
	public Customer(String name, MainSystem system) { super(name, system); }

	public void selectProduct() { mainSystem.select(); }
	public void informationProduct() { mainSystem.information(); }
	public void askPay(Cashier cashier) {cashier.payProduct();}
	public void askReceipt(Cashier cashier) { cashier.receiptProduct();}
	public void giveProduct() { mainSystem.give(); }
}