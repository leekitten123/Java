package quickcodingThread;

public class bankthread {
	
	int balance = 100;
	
	public int getBalance(){
		return balance;
	}
	
	synchronized void Deposit(int cash){
		balance += cash;
		System.out.println("�ݾ� ��: " + balance + ", " + cash + "�Ա�");
	}
	
	synchronized void Withdraw(int cash){
		balance -= cash;
		System.out.println("�ݾ� ��: " + balance + ", " + cash + "���");
	}
}
