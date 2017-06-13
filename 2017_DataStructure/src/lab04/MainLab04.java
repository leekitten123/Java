package lab04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainLab04 {

	public static void main(String[] args) throws IOException {
		
		Lab04.palidrome(new BufferedReader(new FileReader("/Users/leesangwook/Documents/workspace/DataStructure/src/lab04/Lab04_1.dat")));
		Lab04.paildromeBalanced((new BufferedReader(new FileReader("/Users/leesangwook/Documents/workspace/DataStructure/src/lab04/Lab04_2.dat"))));
	}
}