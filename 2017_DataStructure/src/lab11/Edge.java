package lab11;

public class Edge {

	public int x;
	public int y;
	public int cost;
	
	Edge() { set(0, 0, 0); }
	
	public void show() { System.out.printf("(%d, %d) -> %2d\n", x + 1, y + 1, cost); }
	
	public void set(int x, int y, int cost) {
		
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}