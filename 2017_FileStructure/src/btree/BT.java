package btree;

import java.util.Stack;

public class BT {

	private Node root;
	
	public void insertBT(int newKey) {
		
		if(root == null) { // 루트가 비어 있으면 루트 노드를 생성

			root = new Node(1, null, newKey, null, -1, null);		
			return;
			
		} else {
			
			/** newKey가 입력될 위치 찾기 **/
			Node x = root;
			Stack<Node> s = new Stack<Node>();
			
			do {
				
				int i = 1;
				
				while(i <= x.n && newKey > x.k[i]) {
					
					i += 1;
				}

				if(i <= x.n && newKey == x.k[i]) {
					
					return;
				}
				
				s.push(x);
				x = x.p[i - 1];
				
			} while(x != null);
			
			
			boolean finished = false;
			int midKey = newKey;
			
			Node y = null;
			
			x = s.pop();
			
			do {
				
				if(x.n < 2) {
					
					
					
					finished = false;
				}
				
				
			} while();
			
		}
	}
}
