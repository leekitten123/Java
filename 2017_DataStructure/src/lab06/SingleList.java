package lab06;

public class SingleList {
	
	public Node head;
	
	public SingleList() { head = null; }
	
	// 오름차순 삽입 
	public void insert(int data) {
		
		Node temp = new Node();
		temp.data = data;
		
		Node p = null;
		Node q = null;
		
		if (head == null) {
			head = temp;
		} else if (temp.data < head.data) {
			temp.next = head;
			head = temp;
		} else {
			p = head;
			
			while ((p != null) && (p.data < temp.data)) {
				q = p;
				p = p.next;
			}
			
			if (p != null) {
				temp.next = p;
				q.next = temp;
			} else {
				q.next = temp;
			}
		}
	}

	public boolean isEmpty() { return head == null ? true : false; }
	
	public void display() {
		Node temp = head;
		
		while (temp != null) {
			System.out.print((char)temp.data);
			temp = temp.next;
		}
		
		System.out.println();
	}
}
