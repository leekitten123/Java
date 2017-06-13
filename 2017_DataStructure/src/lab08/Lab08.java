package lab08;

public final class Lab08 {

	public static int evaluation(Node root) {
		
		int value = 0;
		
		if (root != null) {
			
			if ('0' <= root.data && root.data <= '9') {
				
				value = root.data - '0';
				
			} else {
				
				int left = evaluation(root.left);
				int right = evaluation(root.right);
				
				switch(root.data) {
				
				case '+': 
					value = left + right; break;
				case '-': 
					value = left - right; break;
				case '*': 
					value = left * right; break;
				case '/': 
					value = left / right; break;
				}
			}
		}
		
		return value;
	}
	
	public static void inorder(Node root) {
		
		if (root !=null) {
			
			inorder(root.left);
			System.out.print(root.data);
			inorder(root.right);
		}
	}
	
	public static void postorder(Node root) {
		
		if (root !=null) {
			
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data);
		}
	}
	
	public static void preorder(Node root) {
		
		if (root !=null) {
			
			System.out.print(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
}