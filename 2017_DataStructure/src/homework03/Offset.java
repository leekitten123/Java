package homework03;

/***
 * 
 * Data Structure Hw03 <Maze Problem>
 * 20133243 Lee Sang Wook
 * 
 * Documentation
 * 
 * Offset 클래스는 Maze에서 정해진 방향에 따라서 이동할 때,
 * 좌표에 수직으로 혹은 수평으로 얼만큼 이동해야 하는지를 알려줍니다.
 * vert, horiz라는 필드로 구성되어 있습니다.
 * vert는 수직으로, horiz는 수평으로의 이동을 의미합니다.
 * 생성자는 2가지 정보를 받아와서 초기화합니다.
 *
 ***/

public class Offset {

	public int vert;
	public int horiz;
	
	public Offset(int vert, int horiz) {
		
		this.vert = vert;
		this.horiz = horiz;
	}
}