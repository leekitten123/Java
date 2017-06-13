package lab10;

import java.util.LinkedList;
import java.util.Queue;

public class AdjacenyListGraph {
	
	private final int MAX_VERTICES = 10;
	
	private boolean[] visited = new boolean[MAX_VERTICES];
	
	private Node[] graph =  new Node[MAX_VERTICES];
	
	AdjacenyListGraph() { init(); }
	
	AdjacenyListGraph(int[][] matrix) {
		
		init();
		
		for (int i = 0 ; i < matrix.length ; i++) {
			
			Node temp = graph[i];
			
			for (int j = 0 ; j < matrix.length ; j++) {
				
				if (matrix[i][j] != 0) {
				
					temp.next = new Node(j);
					temp = temp.next;
				}	
			}
		}
	}
	
	public void display() {
	
		for (int i = 0 ; i < MAX_VERTICES ; i++) {
			
			if (graph[i].next != null) {
				
				System.out.print("V" + i + ": ");
				
				Node temp = graph[i];
				
				while (temp.next != null) {
					
					temp = temp.next;
					
					System.out.print(temp.next != null ? temp.data + " -> " : temp.data);
				}
				
				System.out.println();
			}
		}
	}
	
	public void insert(int num1, int num2) {
		
		Node temp = graph[num1];
		
		while ((temp.next != null) && !(num2 < temp.next.data)) {
			
			temp = temp.next;
		}
		
		if (temp.next == null) {
		
			temp.next = new Node(num2);
		} else {
			
			Node node = temp.next;
			
			temp.next = new Node(num2);
			
			temp.next.next = node;
		}
	}
	
	public void init() {
		
		for (int i = 0 ; i < MAX_VERTICES ; i++) {
			
			graph[i] = new Node(i); 
		}
	}
	
	public void DFS(int v) {
		
		visited = new boolean[MAX_VERTICES];
		
		System.out.print("DFS: ");
		recursiveDFS(v);
		System.out.println();
	}	
	public void recursiveDFS(int v) {
		
		visited[v] = true;
		
		System.out.print("V" + v);
		
		for (Node w = graph[v] ; w.next != null ; w = w.next) {
			
			if (!visited[w.next.data]) {
				
				System.out.print(" -> ");
				recursiveDFS(w.next.data);
			}
		}
	}
	
	public void BFS(int v) {
		
		visited = new boolean[MAX_VERTICES];
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(graph[v]);
		visited[v] = true;
		System.out.print(v);
		
		while (!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			for (Node i = temp ; i.next != null ; i = i.next) {
				
				if (!visited[i.next.data]) {
					
					queue.add(graph[i.next.data]);
					visited[i.next.data] = true;
					System.out.print(i.next.data);
				}
			}
		}
		
		System.out.println();
	}
}
