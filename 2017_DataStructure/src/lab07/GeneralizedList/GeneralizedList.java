package lab07.GeneralizedList;

public class GeneralizedList {

	public Node head;
	
	public GeneralizedList() { head = null; }
	
	public void insert(GeneralizedList list) {

		Node temp = new Node(list);
		
		if (head == null) {
			
			head = temp;
			
		} else {
			
			Node p = head;
			
			while (p.next != null) {
				
				p = p.next;
			}
			
			p.next = temp;
		}
	}
	
	public void insert(int data) {
	
		Node temp = new Node(data);
		
		if (head == null) {
			
			head = temp;
			
		} else {
			
			Node p = head;
			
			while (p.next != null) {
				
				p = p.next;
			}
			
			p.next = temp;
		}
	}

	public void display() {
		
		Node p = head;
		
		while (p != null) {
			
			if (p.tag == 0) {
				
				System.out.print(p.data);
				
			} else {
				
				p.list.display();
			}
			
			p = p.next;
		}
	}
}
