package lab07;

public class DoubleLinkedList {
	
	private Node head;
	
	public boolean isEmpty() { return head == null; }
	
	// 오름차순 삽입 
	public void insert(int data) {
		
		Node temp = new Node();
		temp.data = data;
		
		if (isEmpty()) {
			
			head = temp;
			
		} else if (temp.data < head.data){
			
			temp.next = head;
			head.prev = temp;
			head = temp;
			
		} else {
			
			Node p = head;
			Node q = head;
			
			while ((p != null) && (p.data < temp.data)) {
			
				q = p;
				p = p.next;
			}
			
			if (p != null) {
				
				temp.next = p;
				temp.prev = q;
				
				q.next = temp;
				p.prev = temp;
				
			} else {
				
				q.next = temp;
				temp.prev = q;
			}
		}
	}

	public void forwardDisplay() {
		 
		Node temp = head;
		 
		 while(temp != null) {
			 
			 System.out.print(temp.data);
			 temp = temp.next;
		 }
		 
		 System.out.println();
	}
	
	public void delete(int data) {
		
		if (head.data == data) {
			
			if (head.next != null) {
				
				head = head.next;
				head.prev = null;
				
			} else {
				
				head = null;
			}
		} else {
		
			Node p = head;
			Node q = head;
			
			while ((p != null) && (p.data != data)) {
				
				q = p;
				p = p.next;
			}
			
			if (p != null) {
				
				q.next = p.next;
				
				if (p.next != null) {
					p.next.prev = q;
				} else {
					
				}
				
			}
		}
	}
	
	public void backwardDisplay() {
		
		Node temp = head;
		 
		 while(temp.next != null) {
			 
			 temp = temp.next;
		 }
		 
		 while (temp != null) {
			
			 System.out.print(temp.data);
			 temp = temp.prev;
		 }
		 
		 System.out.println();
	}

	public boolean search(int data) {
		
		if (!isEmpty()) {
			Node temp = head;
			
			while ((temp != null) && (temp.data != data)) {
				
				temp = temp.next;
			}
			
			if (temp != null) {
				
				return true;
				
			} else {
				
				return false;
			}	
		} else {
			
			return false;
		}
	}

	public void quit() { head = null; }
	
	public int length() {
		
		Node p = head;
		
		int length = 0;
		
		while (p != null) {
			
			length++;
			
			p = p.next;
		}
		
		return length;
	}
}
