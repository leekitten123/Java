package lab08;

public class Node {
	
	public char data;
	public int prio;
	
	public Node left;
	public Node right;
	
	Node (char data) {
		
		this.data = data;
		this.prio = 5;
		
		this.left = null;
		this.right = null;
	}
}
