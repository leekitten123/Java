package payment;

public class Payment {

	String type;
	int money;
	
	Payment(String type, int money) {
		this.type = type;
		this.money = money;
	}

	public int getMoney() { return money; }
}
