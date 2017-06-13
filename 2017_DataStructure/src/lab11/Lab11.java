package lab11;

import java.util.LinkedList;
import java.util.Stack;

public final class Lab11 {
	
	public static void kruskal(int[][] graph) {
		
		int n = graph.length;
		
		int[][] tempGraph = copyArray(graph);
		int[][] newGraph = new int[n][n];
		
		LinkedList<Edge> list = new LinkedList<Edge>();
		
		boolean[] vertex = new boolean[n];
		initTrue(vertex);
		
		while (list.size() != n - 1 && !isZero(tempGraph)) {
			
			Edge edge = getMinEdge(tempGraph, vertex, n);
			
			setGraphPoint(newGraph, edge.x, edge.y, tempGraph[edge.x][edge.y]);
			setGraphPoint(tempGraph, edge.x, edge.y);
			
			if (isCycle(newGraph)) {
				
				setGraphPoint(newGraph, edge.x, edge.y);		
			} else {
				
				list.add(edge);
			}
		}
		
		isSpanningTree(tempGraph);
		printPath(list);
	}
	public static void prim(int[][] graph) {
		
		int n = graph.length;
		
		int[][] tempGraph = copyArray(graph);
		
		LinkedList<Edge> list = new LinkedList<Edge>();
		
		boolean[] vertex = new boolean[n];
		vertex[0] = true;

		while (list.size() < n - 1 && !isZero(tempGraph)) {
	
			Edge edge = getMinEdge(tempGraph, vertex, n);
			
			setGraphPoint(tempGraph, edge.x, edge.y);
			
			if ((!vertex[edge.x] && vertex[edge.y]) || (vertex[edge.x] && !vertex[edge.y])) {
					
				list.add(edge);
					
				vertex[edge.x] = true;
				vertex[edge.y] = true;
			}
		}
		
		isSpanningTree(tempGraph);
		printPath(list);
	}

	private static void printPath(LinkedList<Edge> list) {
		
		int cost = 0;
		
		System.out.println("Vertex -> Cost");
		
		for (int i = 0 ; i < list.size() ; i++) {
			
			cost += list.get(i).cost;
			list.get(i).show();
		}

		System.out.println("COST: " + cost);
	}
	private static void setGraphPoint(int[][] graph, int x, int y, int value) {
		
		graph[x][y] = value;
		graph[y][x] = value;
	}
	private static void setGraphPoint(int[][] graph, int x, int y) {
		
		setGraphPoint(graph, x, y, 0);
	}
	
	private static Edge getMinEdge(int[][]graph, boolean[] vertex, int n) {
		
		Edge edge = new Edge();
		
		Loop: for (int i = 0 ; i < n ; i++) {
			
			for (int j = 0 ; j < n ; j++) {
				
				if (graph[i][j] == leastCostEdge(graph, vertex)) {

					edge.set(i, j, graph[i][j]);

					break Loop;
				}
			}
		}
		
		return edge;
	}

	private static int[][] copyArray(int[][] graph) {
		
		int n = graph.length;
		
		int[][] tempGraph = new int[n][n];
		
		for (int i = 0 ; i < n ; i++) {
			
			for (int j = 0 ; j < n ; j++) {
				
				tempGraph[i][j] = graph[i][j];
			}
		}
		
		return tempGraph;
	}

	private static int leastCostEdge(int[][] graph, boolean[] vertex) {
		
		int min = 10000;
		
		for (int i = 0 ; i < graph.length ; i++) {
			
			min = (vertex[i] && min > leastCostEdge(graph[i])) ? leastCostEdge(graph[i]) : min;
		}
		
		return min;
	}
	private static int leastCostEdge(int[] graph) {
		
		int min = 10000;
		
		for (int i = 0 ; i < graph.length ; i++) {
			
			min = (graph[i] != 0 && min > graph[i]) ? graph[i] : min;
		}
		
		return min;
	}
	
	private static boolean[] initTrue(boolean[] vertex) {
		
		for (int i = 0 ; i < vertex.length ; i++) {
			
			vertex[i] = true;
		}
		
		return vertex;
	}
	
	private static boolean isCycle(int[][] graph) {
		
		int length = graph.length;
		
		for (int j = 0 ; j < length ; j++) {
			
			int[] visited = new int[length];
			
			Stack<Integer> stack = new Stack<Integer>();
			
			stack.add(j);
			
			while (!stack.isEmpty()) {
				
				int temp = stack.pop();
				visited[temp] += 1;
				
				for (int i = 0 ; i < length ; i++) {
					
					if (visited[i] == 0 && graph[temp][i] != 0) {
						
						stack.push(i);
					}
				}
			}
			
			for (int i = 0 ; i < length ; i++) {
				
				if (visited[i] > 1) {
					
					return true; 
				}
			}
		}
		
		return false;
	}	
	private static boolean isZero(int[][] graph) {
		
		for (int i = 0 ; i < graph.length ; i++) {
			
			for (int j = 0 ; j < graph.length ; j++) {
				
				if (graph[i][j] != 0) {
					
					return false;
				}
			}
		}
		
		return true;
	}
	private static boolean isSpanningTree(int[][] graph) {
		
		if (isZero(graph)) {
			
			System.out.println("No Spanning Tree");
			
			return false;
		}
		
		return true;
	}
}