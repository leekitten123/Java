package lab08;

public class Tree {

	public Node root;
	
	private char[][] prec = {
			{'^', 3},
			{'*', 2},
			{'/', 2},
			{'+', 1},
			{'-', 1}};
	
	public Tree() { root = null; }
	public Tree(String str) { makeTree(str); }
	
	private void makeTree(String str) {
		
		for (int i = 0 ; i < str.length() ; i++) {
			
			Node temp = new Node(str.charAt(i));
			
			for (int j = 0 ; j < 5 ; j++) {
				
				if (temp.data == prec[j][0]) {
					
					temp.prio = prec[j][1];
				}
			}
						
			if (temp.prio == 5) {
				
				if (root == null) {
					
					root = temp;
					
				} else {
					
					Node p = root;
					
					while (p.right != null) {
						
						p = p.right;
					}
					
					p.right = temp;
				}
			} else {
				
				if (root.prio >= temp.prio) {
					
					temp.left = root;
					root = temp;
				
				} else {
					
					temp.left = root.right;
					root.right = temp;
				}
			}
		}
	}

	public int evaluation() {
	
		Node p = root;
		
		while (p.left !=null) {
			
			p = p.left;
		}
		
		if (!Character.isAlphabetic(p.data)) {
			
			return Lab08.evaluation(root);
			
		} else {
			
			System.out.print("Not Number");
			return -1;
		}
	}
	
	public void inorder() {
		
		Lab08.inorder(root);
		System.out.println();
	}
	
	public void postorder() {
		
		Lab08.postorder(root);
		System.out.println();
	}
	
	public void preorder() {
		
		Lab08.preorder(root);
		System.out.println();
	}
}