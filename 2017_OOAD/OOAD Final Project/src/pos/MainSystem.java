package pos;

import product.*;
import event.*;

public class MainSystem {

	Event event;
	
	ProductDB productDB = new ProductDB();
	ProductBuy productBuy = new ProductBuy();
	
	public void manage() { event = new EventPManage(productDB); }
	public void select() { event = new EventPSelect(productDB, productBuy); }
	public void information() { event = new EventPInfo(productBuy); }
	public void pay() { event = new EventPPay(productBuy); }
	public void receipt() { event = new EventPReceipt(productBuy); }
	public void give() { event = new EventPGive(productBuy); }
}
