package lab03;

import java.io.FileNotFoundException;

public class MainLab03 {

	public static void main(String[] args) throws FileNotFoundException {

		Lab03 lab03 = new Lab03();
		lab03.array();
		
		Term[] term = new Term[9];
		Term[] newTerm = new Term[9];

		term[0] = new Term(6, 6, 8);
		term[1] = new Term(0, 0, 15);
		term[2] = new Term(0, 3, 22);
		term[3] = new Term(0, 5, -15);
		term[4] = new Term(1, 1, 11);
		term[5] = new Term(1, 2, 3);
		term[6] = new Term(2, 3, -6);
		term[7] = new Term(4, 0, 91);
		term[8] = new Term(5, 2, 28);
		
		Transpose transpose = new Transpose();
		transpose.fast_transpose(term, newTerm);
		
		
	}
}
