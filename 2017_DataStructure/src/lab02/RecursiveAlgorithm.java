package lab02;

/*
 * 
 * 20133243 Lee Sang Wook
 * Lab02 <RecursiveAlgorithm.java>
 *
 */

public final class RecursiveAlgorithm {
	
	public static int factorial(int n) {
		
		return (n == 0) ? 1 : (n * factorial(n - 1)) ;
	}
	
	public static int binarySearch(int[] list, int search, int left, int right) {

		int middle;
		
		if (left <= right) {
			
			middle = (left + right) / 2;
			
			switch (compare(list[middle], search)) {
				case -1: return binarySearch(list, search, middle + 1, right);
				case  0: return middle;
				case  1: return binarySearch(list, search, left, middle - 1);
			}
		}
		
		return -1;
	}
		
	public static int compare(int num1, int num2) {
		
		if (num2 < num1) {
			return 1;
		} else if (num2 > num1) {
			return -1;
		} else {
			return 0;
		}
	}

	public static void towerHanoi(char from, char to, char aux, int n) {
		
		if (n == 1) {
			System.out.println("move disk 1 from peg" + from + " to peg" + to);
			
		} else {
			towerHanoi(from, aux, to , n - 1);
			System.out.println("move disk " + n + " from peg" + from + " to peg" + to);
			towerHanoi(aux, to, from, n - 1);
		}
	}

}
