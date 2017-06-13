package lab12;

import java.util.Scanner;

public class MainLab12 {

	//Insert 7insert 36find 7insert 29insert 22find 25delete 22
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Hash hash = new Hash();
		
		boolean isQuit = false;
		
		while (!isQuit) {
			
			System.out.println("1.Insert 2.Find 3.Delete 4.Quit");
			
			System.out.print("Select > ");
			int key = scanner.nextInt();
			
			switch (key) {
			
			case 1:
				
				System.out.print("Key > ");
				
				if (hash.insertKey(scanner.nextInt())) {
					
					hash.print();
				} else {
					
					System.out.println("Cannot Insert Key");
				}
				
				break;
				
			case 2:
				
				System.out.print("Key > ");
				
				hash.findKey(scanner.nextInt());
				break;
				
			case 3:
				
				System.out.print("Key > ");
				
				if (hash.deleteKey(scanner.nextInt())) {
					
					hash.print();
				} else {
					
					System.out.println("Bad Command");
				}
				
				break;
				
			case 4:
				isQuit = true;
				break;
			}
		}
		
		scanner.close();
	}
}