package quickcodingThread;

public class quickcodingthread {	
	public static void main(String[] args) {
		bankthread account = new bankthread();
		
		Thread depositer = new Thread(){
			public void run(){
				for(int i = 0 ; i < 10 ; i++){
					account.Deposit(10);
					try {
						Thread.sleep((int)(Math.random()*1000));
					} catch (Exception e) {}
				}
			}
		};
		
		Thread withdrawer = new Thread(){
			public void run(){
				for(int i = 0 ; i < 10 ; i++){
					account.Withdraw(10);
					try{
						Thread.sleep((int)(Math.random() * 1000));
					}catch (Exception e) {}
				}
			}
		};
		
		depositer.start();
		withdrawer.start();
	}
}
