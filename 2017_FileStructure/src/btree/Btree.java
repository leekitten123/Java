package btree;

import java.util.Stack;

public class Btree {

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
			
			/**  **/
			boolean finished = false;
			
			int midKey = newKey;
			
			Node y = null;
			
			x = s.pop();
			
			do {
				
				if(x.n < 2) {
					
					//***insert
					Node tempNode = new Node(x.n, x.p[0], x.k[1], x.p[1], x.k[2], x.p[2]);
					
					if(midKey > x.k[1]) {
						
						x.setNode(2, tempNode.p[0], tempNode.k[1], tempNode.p[1], midKey, y);
						
					} else {
						
						x.setNode(2, tempNode.p[0], midKey, y, tempNode.k[1], tempNode.p[1]);
					}
						
					finished = true;
					
				} else {
					
					Node tempNode = new Node(x.n, x.p[0], x.k[1], x.p[1], x.k[2], x.p[2]);
					
					if(midKey < tempNode.k[1]) {
						
						x.setNode(1, tempNode.p[0], midKey, y, -1, null);
						y = new Node(1, tempNode.p[1], tempNode.k[2], tempNode.p[2], -1, null);
						midKey = tempNode.k[1];
						
					} else if(tempNode.k[2] < midKey) {
						
						x.setNode(1, tempNode.p[0], tempNode.k[1], tempNode.p[1], -1, null);
						y = new Node(1, tempNode.p[2], midKey, y, -1, null);
						midKey = tempNode.k[2];
					
					} else {
						
						x.setNode(1, tempNode.p[0], tempNode.k[1], tempNode.p[1], -1, null);
						y = new Node(1, y, tempNode.k[2], tempNode.p[2], -1, null);
					}
					
					if(!s.isEmpty()) {
						
						x = s.pop();
						
					} else {
						
						Node nNode = new Node(1, x, midKey, y, -1, null);
						
						root = nNode;
						
						finished = true;
					}
					
				}
				
			} while(!finished);
			
		}
		
	}

	public void inorder(Node node) {
		
		if(node != null) {
			
			inorder(node.p[0]);
			
			for(int i = 1; i < 3; i++) {
				if(node.k[i] != -1) {
					System.out.print(node.k[i] + " ");
					inorder(node.p[i]);
				}
			}
		}
	}
	
	public void Inorder() {
		inorder(root);
		System.out.print("\n");
	}
}