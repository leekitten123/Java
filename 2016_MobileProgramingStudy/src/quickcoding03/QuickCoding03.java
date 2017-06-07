package quickcoding03;

import java.util.Scanner;

public class QuickCoding03 {

	public static void main(String[] args) throws Exception{
		
		Scanner scan = new Scanner(System.in) ;		
		
		String a, b ;
		
		int a1 = 0, b1 =0 ;
		int ans = 0 ;
		
		try {
			a = scan.next() ;
			b = scan.next() ;
			
			a1 = Integer.parseInt(a) ;
			b1 = Integer.parseInt(b) ;
			
			if (a1 >= 100 || b1 >= 100) {
				throw new Exception("Number is Bigger than 100") ;
			}
			
			ans = a1 / b1 ;
			
		} catch (Exception e) {
			System.out.println(e.getMessage()) ;
		}		
	}			
}