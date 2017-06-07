package binarysearch;

public class BinarySearch {
	
	public static void main(String[] args) {
	
		int[] Array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} ;
		
		int target = (int) (Math.random() * 10 + 1) ;
		
		int first = 1 ;
		int last = Array.length ;
	
		int mid ;
	
		while (first <= last) {
	
			mid = (first + last) / 2 ;
			
			if(target == Array[mid]) {
				
				System.out.println(Array[mid]) ;
				break ;
			
			} else if (target > Array[mid]) {
			
				first = mid + 1 ;
				mid = (first + last) / 2 ;
			
			} else {
				
				last = mid - 1 ;
				mid = (first + last) / 2 ;
			
			}
		}
	}
}
