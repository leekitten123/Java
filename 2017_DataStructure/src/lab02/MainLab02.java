package lab02;

import java.util.Scanner;

/*
 * 
 * 20133243 Lee Sang Wook
 * Lab02 <Main.java>
 *
 */

public class MainLab02 {

	public static void main(String[] args) {

		// Lab02-1 : Recursive & Iterative Addition
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		Lab02.addIterator(a, b);
		System.out.println("");
		
		Lab02.addRecursive(a, b);
		System.out.println("");

		// Lab02-2 : Find FIBONACCI number
		int c = scanner.nextInt();
		System.out.println(Lab02.fibonachiRecursive(c));
		
		scanner.close();
	}

}
