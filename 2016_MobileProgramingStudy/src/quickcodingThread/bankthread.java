package quickcodingThread;

public class bankthread {
	
	int balance = 100;
	
	public int getBalance(){
		return balance;
	}
	
	synchronized void Deposit(int cash){
		balance += cash;
		System.out.println("금액 합: " + balance + ", " + cash + "입금");
	}
	
	synchronized void Withdraw(int cash){
		balance -= cash;
		System.out.println("금액 합: " + balance + ", " + cash + "출금");
	}
}
