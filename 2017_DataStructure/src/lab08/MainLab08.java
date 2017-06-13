package lab08;

import java.util.Scanner;

public class MainLab08 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0 ; i < 4 ; i++) {
			
			// 8+9-2*3
			// A/B*C*D+E
			// a+b*c-d
			// 3+2
			
			String str = scanner.nextLine();
			
			Tree tree = new Tree(str);
			
			System.out.print("Evaluation: ");
			System.out.println(tree.evaluation());
			
			System.out.print("Inorder: ");
			tree.inorder();
			
			System.out.print("Postorder: ");
			tree.postorder();
			
			System.out.print("Preorder: ");
			tree.preorder();
			
			System.out.println();
		}
				
		scanner.close();
	}
}