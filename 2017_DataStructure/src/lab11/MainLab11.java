package lab11;

public class MainLab11 {
	
	public static void main(String[] args) {
		
		int[][] graph = {
				{100,   2,   1,   5, 100, 100},
				{  2, 100,   4, 100,   3, 100},
				{  1,   4, 100,   6,   6,   7},
				{  5, 100,   6, 100, 100,   2},
				{100,   3,   6, 100, 100,   6},
				{100, 100,   7,   2,   6, 100}};
		
		System.out.println("Prim's Algorithm");
		Lab11.prim(graph);
		
		System.out.println();
		
		System.out.println("Kruskal's Algorithm");
		Lab11.kruskal(graph);
	}
}