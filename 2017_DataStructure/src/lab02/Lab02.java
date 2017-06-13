package lab02;

/*
 * 
 * 20133243 Lee Sang Wook
 * Lab02 <Lab02.java>
 *
 */

public final class Lab02 {

	public static int addIterator(int a, int b) {
		
		while (a != 0) {
			
			System.out.print("(" + a + ", " + b + ") ");
		
			a--;
			b++;
		}
		
		System.out.print("(" + a + ", " + b + ") ");
		
		return b;
	}
	
	public static int addRecursive(int a, int b) {
		
		System.out.print("(" + a + ", " + b + ") ");
		
		if (a != 0) {
			return addRecursive(a-1, b+1);
		} else {
			return b;
		}
	}

	public static int fibonachiRecursive(int n) {
		
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonachiRecursive(n - 1) + fibonachiRecursive(n - 2);
		}
	}
}