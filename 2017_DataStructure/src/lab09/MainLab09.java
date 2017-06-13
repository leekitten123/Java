package lab09;

import java.util.Scanner;

public class MainLab09 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean quit = true;
		
		MaxHeap maxHeap = new MaxHeap();
		
		while (quit) {
		
			System.out.println("1.Insert 2.Delete 3.Empty 4.Full 5.Quit 6.Init");
			System.out.print("Select Menu: ");
			
			int n = scanner.nextInt();
			
			switch(n) {
				
			case 1:
				System.out.print("Number: ");
				maxHeap.insert(scanner.nextInt());
				maxHeap.show();
				break;
				
			case 2:
				maxHeap.delete();
				maxHeap.show();
				break;
				
			case 3:
				System.out.println(maxHeap.isEmpty() ? "Heap is Empty" : "Heap is not Empty");
				System.out.println();
				break;
				
			case 4:
				System.out.println(maxHeap.isFull() ? "Heap is Full" : "Heap is not full");
				System.out.println();
				break;
				
			case 5:
				quit = false;
				break;
				
			case 6:
				init(maxHeap);
				maxHeap.show();
				break;
			}
		}
		
		scanner.close();
	}
	
	private static void init(MaxHeap maxHeap) {
		
		maxHeap.insert(8);
		maxHeap.insert(6);
		maxHeap.insert(4);
		maxHeap.insert(2);
		maxHeap.insert(5);
		maxHeap.insert(3);
	}
}