package lab07.GeneralizedList;

public class Node {

	public int tag;
	
	public int data;
	public GeneralizedList list;
	
	public Node next;
	
	public Node () {
		
		this.tag = 0;
		this.data = 0;
		this.list = null;
		this.next = null;
	}
	
	public Node (int data) {
		
		this.tag = 0;
		this.data = data;
		this.list = null;
		this.next = null;
	}
	
	public Node (GeneralizedList list) {
		
		this.tag = 1;
		this.data = 0;
		this.list = list;
		this.next = null;
	}
}
