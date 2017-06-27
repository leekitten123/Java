package pos;

import java.util.ArrayList;
import java.util.Scanner;

import pos.inputdevice.*;
import pos.outputdevice.Monitor;
import pos.outputdevice.ReceiptPrinter;
import pos.paymentdevice.CreditCardMachine;
import pos.paymentdevice.MoneyStorageDevice;
import pos.paymentdevice.PaymentDevice;
import pos.type.Product;

/***
 * 
 * 20133243 Lee Sang Wook
 * POSProcessor.java
 * 
 ***/

public class POSProcessor {
	
	/* Devices */
	private Scanner scanner;

	private BarcodeScanner barcodeScanner;
	private Keyboard keyboard;
	
	private Monitor monitor;
	private ReceiptPrinter receiptPrinter;
	
	private CreditCardMachine creditCardMachine;
	private MoneyStorageDevice moneyStorageDevice;
	
	/* Product list */
	private ArrayList<Product> productList;  
	
	/* Connect Devices */
	public POSProcessor() {
		
		scanner = new Scanner(System.in);
		
		barcodeScanner = new BarcodeScanner();
		keyboard = new Keyboard();
		
		monitor = new Monitor();
		receiptPrinter = new ReceiptPrinter();
		
		creditCardMachine = new CreditCardMachine();
		moneyStorageDevice = new MoneyStorageDevice();
		
		productList = new ArrayList<>(); 
	}
	
	/* Total price */
	private int getTotalProductPrice() {
		
		int total = 0;
		
		for (int i = 0 ; i < productList.size() ; i++) {
			
			total += productList.get(i).getPrice();
		}
		
		return total;
	}
	
	/* Process */
	public void process() {
				
		order();
		pay();
	}
	
	/* Order process */
	private void order() {
		
		while (true) {
			
			monitor.showMenu(monitor.menuMain);
			int numOrderMenu = keyboard.scanInt();
			
			if (numOrderMenu == 1) { // Order
				
				monitor.showMenu(monitor.menuHowToOrder);
				int numHowToOrder = keyboard.scanInt();

				if (numHowToOrder == 1) { // Input by keyboard
					
					addProductData(keyboard);
					
				} else if (numHowToOrder == 2) { // Input by keyboard
					
					addProductData(barcodeScanner);
					
				} else {
					
					monitor.showStr("Retry!");
					
				}
			} else if (numOrderMenu == 2) { // Show product list
				
				monitor.printProductData(productList);
				
			} else if (numOrderMenu == 3) { // Pay
				
				monitor.showTotalPrice(getTotalProductPrice());
				break;
				
			} else { // Retry
				
				monitor.showStr("Retry!");
			}
		}
	}

	/* Pay */
	private void pay() {
		
		while (true) {

			monitor.showMenu(monitor.menuHowToPay);
			int numHowToPay = keyboard.scanInt();
			
			if (numHowToPay == 1) { // Pay by credit card machine
				
				payCheck(creditCardMachine, false);
				printReceipt(creditCardMachine, true);
				break;
				
			} else if (numHowToPay == 2) { // Pay by money storage device
				
				payCheck(moneyStorageDevice, true);
				printReceipt(moneyStorageDevice, false);
				break;
				
			} else { // Retry
				
				monitor.showStr("Retry!");
			}
		}
	}
	
	/* Real Pay */
	private void payCheck(PaymentDevice paymentDevice, boolean isKeyNeed) {

		int price;
		
		while(true) {

			if (isKeyNeed) {
				
				price = scanner.nextInt();
			} else {
				
				price = 100000;
			}
			
			System.out.println("Start Caluculation");

			paymentDevice.setPayment(true, price);
			
			if (getTotalProductPrice() <= paymentDevice.getPayment().getPrice()) {
					
				break;
			}
			
			System.out.println("Not Enough Money");
		}
		
		System.out.println("Success Calculation");
	}
	
	/* Add product list */
	private void addProductData(InputDevice inputDevice) {
		
		inputDevice.activate();

		if (inputDevice.getProduct().getName() != "-1") {
			
			productList.add(inputDevice.getProduct());
		}
	}
	
	/* Print recipt */
	private void printReceipt(PaymentDevice paymentDevice, boolean isCard) {
		
		receiptPrinter.showStr("***************************");
		
		if (isCard) {
			
			receiptPrinter.showStr("Payment : Card");
			
		} else {
			
			receiptPrinter.showStr("Payment : Cash");
		}
		
		receiptPrinter.printProductData(productList);
		receiptPrinter.showChange(paymentDevice.getPayment().getPrice() - getTotalProductPrice());
	
		receiptPrinter.showStr("***************************");
	}
}