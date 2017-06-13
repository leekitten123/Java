package lab07;

import java.util.Scanner;

public class MainLab07 {

	public static void main(String[] args) {

		DoubleLinkedList dll = new DoubleLinkedList();
		
		boolean exit = false;
		
		Scanner scanner = new Scanner(System.in);
		
		while (!exit) {
			
			System.out.println("1.Insert 2.Delete 3.Backward 4.Forward 5.Search 6.Length 7.Quit");
			System.out.print("> ");
			
			switch (scanner.nextInt()) {
			case 1:
				System.out.print("Insert Number > ");
				dll.insert(scanner.nextInt());
				break;
			case 2:
				System.out.print("Delete Number > ");
				dll.delete(scanner.nextInt());
				break;
			case 3:
				System.out.print("Backward > ");
				dll.backwardDisplay();
				break;
			case 4:
				System.out.print("Forward > ");
				dll.forwardDisplay();
				break;
			case 5:
				System.out.print("Search Number > ");
				System.out.println(dll.search(scanner.nextInt()) ? "> Found" : "> Not Found");
				break;
			case 6:
				System.out.println("Length > " + dll.length());
				break;
			case 7:
				System.out.println("Quit");
				dll.quit();
				scanner.close();
				exit = true;
				break;
			}
		}
	}
}
