package lab12;

public class Node {

	int key;
	Node next;
	
	Node() { this.next = null; }
	Node(int key) {
		
		this.key = key;
		this.next = null;
	}
}