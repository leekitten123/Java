package main;
import java.util.Scanner;

import pos.MainSystem;
import actor.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean isExit = false;

		MainSystem system = new MainSystem();
		
		Cashier cashier = new Cashier("Lee", system);
		Customer customer = new Customer("Megan", system);
		
		while(!isExit) {
			
			System.out.println("1.Manage 2.Select 3.Info 4.Pay 5.Receipt 6.Give 7.Exit");

			switch (scanner.nextInt()) {
			case 1: cashier.manageProduct(); break;
			case 2: customer.selectProduct(); break;
			case 3: cashier.informationProduct(); break;
			case 4: customer.askPay(cashier); break;
			case 5: customer.askReceipt(cashier); break;
			case 6: cashier.askGive(customer); break;
			case 7: isExit = true; break;
			}
		}
	}
}
