package lab09;

public class MaxHeap {
	
	private final int MAXSIZE = 8;
	
	private int n;
	private int[] heap;
	
	public MaxHeap() { n = 0; heap = new int[MAXSIZE + 1]; }
	
	public boolean isFull() { return (n == MAXSIZE) ? true : false; }
	public boolean isEmpty() { return (n == 0) ? true : false; }
	
	public void insert(int item) {
		
		if (isFull()) {
			
			System.out.println("Heap is Full");
			
		} else {
		
			int i = ++n;
			
			while((i != 1) && (item > heap[i / 2])) {
				
				heap[i] = heap[i / 2];
				
				i /= 2;
			}
			
			heap[i] = item;
		}
	}
	
	public int delete() {
	
		int item = heap[1];
		int temp = heap[n--];
		
		int parent = 1;
		int child = 2;
		
		while (child <= n) {
			
			if ((child < n) && (heap[child] < heap[child + 1])) {
				
				child++;
			}
			
			if (temp >= heap[child]) {
				
				break;
			}
			
			heap[parent] = heap[child];
			parent = child;
			child *= 2;	
		}
		
		heap[parent] = temp;
		
		return item;
	}

	public void show() {
		
		System.out.print("Heap: (");
		
		for (int i = 0 ; i < n ; i++) {
			
			System.out.print(i != (n - 1) ? heap[i + 1] + " " : heap[i + 1]);
		}
		
		System.out.print(")");
		
		int temp = n;
		
		for (int i = 0 ;  ; i++ ) {
			
			temp /= 2;
			
			if (temp == 0) {
				
				System.out.print(" Depth: " + i);
				break;
			}
		}
		
		System.out.println();
	}
}