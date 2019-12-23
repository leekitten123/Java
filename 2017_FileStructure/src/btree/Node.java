package btree;

public class Node {
	
	public int n;
	
	public int[] k = new int[4];
	
	public Node[] p = new Node[4];
	
	public Node(int n, Node p0, int k1, Node p1, int k2, Node p2) { setNode(n, p0, k1, p1, k2, p2 ); }
	
	public void setNode(int n, Node p0, int k1, Node p1, int k2, Node p2) {
		
		this.n = n;
		
		this.k[1] = k1;
		this.k[2] = k2;
		
		this.p[0] = p0;
		this.p[1] = p1;
		this.p[2] = p2;
	}
}