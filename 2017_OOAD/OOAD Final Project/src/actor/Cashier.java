package actor;
import pos.MainSystem;

/**
 * @uml.dependency   supplier="actor.Customer"
 */
public class Cashier extends Actor{

	public Cashier(String name, MainSystem system) { super(name, system); }
	
	public void manageProduct() { mainSystem.manage(); }
	public void informationProduct() { mainSystem.information(); }
	public void payProduct() { mainSystem.pay(); }
	public void receiptProduct() { mainSystem.receipt(); }
	public void askGive(Customer customer) { customer.giveProduct();}
}
