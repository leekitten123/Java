package lab01;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * 
 * 20133243 Lee Sang Wook
 * Lab01 <Main.java>
 *
 */

public class MainLab01 {

	public static void main(String[] args) throws Exception {

		// Lab01-1 : Find Min & Max
		int[] data= {90, 40, 60, 10, 50, 80, 20, 70};
		int size = 8;
		
		Lab01.findMinMax(data, size);
		
		System.out.println("");
		
		// Lab01-2 : File IO
		Lab01.fileIO(new BufferedReader(new FileReader("/Users/leesangwook/Documents/workspace/DataStructure/src/lab01/Lab01.dat")));
	}
}
