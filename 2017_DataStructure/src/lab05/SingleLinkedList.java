package lab05;

public class SingleLinkedList {

	private Node head;
	
	public SingleLinkedList() { head = null; }
	
	private Node createNode(String name, int id, String major, String grade, Node next) {
		
		Node node = new Node();
		
		node.name = name;
		node.id = id;
		node.major = major;
		node.grade = grade;
		
		node.next = next;
		
		return node;
	}
	
	public void insert(String name, int id, String major, String grade) {
	
		Node temp = createNode(name, id, major, grade, null);
		Node p = null;
		Node q = null;
		
		if (head == null) {
			head = temp;
		} else if (compare(temp.name, head.name)) {
			temp.next = head;
			head = temp;
		} else {
			p = head;
			
			while ((p != null) && compare(p.name, temp.name)) {
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
	
//	public void insert(int index, int data) {
//				
//		Node temp = new Node();
//		temp.data = data;
//		temp.next = null;
//		
//		if (index > 1) {
//	
//			Node p = head;
//			
//			for (int i = 0 ; i < index - 2 ; i++) {
//				p = p.next;	
//			}
//			
//			Node a = p;
//			
//			temp.next = a.next;
//			p.next = temp;
//	
//		} else if (index == 1) {
//	
//			Node a = head;
//			head = temp;
//			temp.next = a;
//		}
//	}
	
	public void print() {
		Node p = head;
		
		while (p != null) {
			System.out.println(p.name + " " + p.id + " " + p.major +  " " + p.grade);
			p = p.next;
		}
	}

//	public void delete(int data) {
//		
//		if (head.data == data) {
//			
//			head = head.next;
//		} else {
//			
//			Node p = head;
//			Node q = head;
//			
//			while (!(p.next == null)) {
//			
//				q = p;
//				p = p.next;
//				
//				if (p.data == data) {
//				
//					q.next = p.next;
//					break;
//				}
//			}
//		}
//	}
	
//	public void delete(int index) {
// 	
//		if (index == 1) {
//	
//			head = head.next;
//		} else {
//			
//			Node p = head;
//			Node q = head;
//			
//			for (int i = 0 ; i < index - 1 ; i++) {
//				q = p;
//				p = p.next;
//			}
//			
//			q.next = p.next;
//		}
//	}
	
	public boolean compare(String p, String q) {
		
		int i = 0;
		
		for (i = 0 ; i < (p.length() > q.length() ? q.length() : p.length()) ; i++) {
			
			if (p.charAt(i) < q.charAt(i)) {
				return true;
			} else if (p.charAt(i) > q.charAt(i)) {
				return false;
			}
		}
		
		return p.length() > q.length() ? false : true;
	}
	
	public boolean isEmpty() { return (head == null) ? true : false; }
	
	public int size() {
		
		int size = 0;
		
		if (head == null) {
			
			return size;
			
		} else {
			
			Node p = head;
			
			while (p.next != null) {
				p = p.next;
				size++;
			}
			
			return size + 1;
		}
	}
	
	public boolean isExist(String str) {
		
		Node p;
		
		if (!(head == null)) {
			p = head;
			
			while (p != null && p.grade != str) {
				p = p.next;
			}
			
			if (p != null) {
				System.out.println(p.name + " " + p.id + " " + p.major + " " + p.grade);
				return true;
			} else {
				
				return false;
			}
		} else {
			
			return false;
		}
	}

	public void sortPrint(String str) {
		Node p = head;
		
		while (p != null) {
			
			if (p.grade.equals(str)) {
				System.out.println(p.name + " " + p.id + " " + p.major +  " " + p.grade);
			}
			
			p = p.next;
		}
		
	}
}