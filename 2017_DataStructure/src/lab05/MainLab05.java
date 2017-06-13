package lab05;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainLab05 {

	public static void main(String[] args) throws IOException {

		File file1 = new File("/Users/leesangwook/Documents/workspace/DataStructure/src/lab05/data1.dat");
		File file2 = new File("/Users/leesangwook/Documents/workspace/DataStructure/src/lab05/data2.dat");
		
		Scanner scanner1 = new Scanner(file1);
		Scanner scanner2 = new Scanner(file2);
		
		SingleLinkedList sll  = new SingleLinkedList();
		
		while (scanner1.hasNext()) {
			
			sll.insert(scanner1.next(), scanner1.nextInt(), scanner1.next(), scanner1.next());
		}
		
		sll.print();
		System.out.println("");
		
		
		sll.sortPrint("A");
		System.out.println("");
		
		while (scanner2.hasNext()) {
			
			sll.insert(scanner2.next(), scanner2.nextInt(), scanner2.next(), scanner2.next());
		}
		
		sll.print();
		
		scanner1.close();
		scanner2.close();

	}
}