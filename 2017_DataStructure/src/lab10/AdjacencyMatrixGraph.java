package lab10;

import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyMatrixGraph {

	private final int MAX_VERTICES = 10;
	
	private boolean[] visited = new boolean[MAX_VERTICES];
	
	private int[][] graph;
	
	AdjacencyMatrixGraph(int[][] matrix) { graph = matrix; }
	
	public void display() {
		
		for (int i = 0 ; i < graph.length ; i++) {
			
			for (int j = 0 ; j < graph.length ; j++) {
				
				System.out.printf("%3d", graph[i][j]);
			}
			
			System.out.println();
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
		
		for (int i = 0 ; i < graph.length ; i++) {
			
			if (!visited[i] && graph[v][i] == 1) {
				
				System.out.print(" -> ");
				recursiveDFS(i);
			}
		}
	}
	
	public void BFS(int v) {
		
		visited = new boolean[MAX_VERTICES];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(v);
		visited[v] = true;
		System.out.print(v);
		
		while (!queue.isEmpty()) {
			
			int temp = queue.poll();
			
			for (int i = 0 ; i < graph.length ; i++) {
				
				if (!visited[i] && graph[temp][i] == 1) {
					
					queue.add(i);
					visited[i] = true;
					System.out.print(i);
				}
			}
		}
		
		System.out.println();
	}	
}
