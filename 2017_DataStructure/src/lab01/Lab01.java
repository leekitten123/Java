package lab01;

import java.io.BufferedReader;

/*
 * 
 * 20133243 Lee Sang Wook
 * Lab01 <Lab01.java>
 *
 */

public final class Lab01 {

	public static void findMinMax(int[] data, int size) {
		
		int min = data[0];
		int max = data[0];
		
		for (int i = 0 ; i < size ; i++) {
			
			min = (min > data[i]) ? data[i] : min;
			max = (max < data[i]) ? data[i] : max;
		}
		
		System.out.println("Min = " + min);
		System.out.println("Max = " + max);
	}
	
	public static void fileIO(BufferedReader br) throws Exception {
		
		String[] temp = new String[5];
		
		for (int i = 0 ; i < 5 ; i++) {
			
			temp[i] = br.readLine();
			
			System.out.println(temp[i]);
			System.out.println(temp[i].split(" ").length);
		}	
	}
}
