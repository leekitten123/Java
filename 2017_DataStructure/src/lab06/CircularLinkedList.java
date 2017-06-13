package lab06;

public class CircularLinkedList {

	public Node head;
	public Node avail;
	
	public CircularLinkedList() { head = null; }
	
	public void insertFront(int data) {
		
		Node temp = new Node();
		temp.data = data;
		
		if (isEmpty()) {
			
			head = temp;
			temp.next = temp;
		} else {
			
			temp.next = head.next;
			head.next = temp;
		}
	}
	
	public void delete() {
		
		if (!isEmpty()) {
			
			Node p = head.next;
			head.next = p.next;
		}
	}
	
	public boolean isEmpty() { return head == null ? true : false; }
	
	public void display() {
		
		if (head != null) {

			Node p = head.next;
			
			do {
				
				System.out.print(p.data);
				
				p = p.next;
				
			} while (p != head);
			
			System.out.println(p.data);
		} else {
			System.out.println("Empty");
		}
		
	}

	public int length() {
		Node temp;
		int count = 0;
		
		if (!isEmpty()) {
			
			temp = head;
			
			do {
				count++;
				temp = temp.next;
			} while (temp != head);
		}
		
		return count;
	}

	public Node getNode() {
		
		Node node;
		
		if (avail != null) {
			
			node = avail;
			avail = avail.next;
		} else {
			
			node = new Node();
		}

		return node;
	}
	
	public void returnNode(Node node) {
		node.next = avail;
		avail = node;
	}
	
	public void getAvail(int num) {
		
		SingleList temp = new SingleList();
		
		for (int i = 0 ; i < num ; i++) {
			temp.insert(0);
		}
		
		avail = temp.head;
	}

	public void cErase() {
		
		Node temp;
		
		if (head != null) {
			temp = head.next;
			head.next = avail;
			avail = temp;
			head = null;
		}
	}
}