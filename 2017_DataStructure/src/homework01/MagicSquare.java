package homework01;

import java.util.Scanner;

/***
 * 
 * Data Structure Hw01 <Magic Square>
 * 20133243 Lee Sang Wook
 *
 ***/

public class MagicSquare {

	// 메인 함수
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// 숫자를 하나 입력받고, 입력받은 숫자가 3이상의 홀수가 입력될 때까지 반복합니다.
		// 정상적인 입력이 행해지면, 입력받은 수의 크기의 가로, 세로의 마방진을 만들고 출력합니다.
		while (true) {

			System.out.print("숫자를 입력하세요: ");
			int n = scanner.nextInt();
			
			if ((n >= 3) && (n % 2 == 1)) {
				
				getMagicSquare(setMagicSquare(n));
				break;
			}
		}	
		
		scanner.close();
	}
	
	// 가로, 세로의 크기가 n인 마방진을 제작하는 함수입니다.
	private static int[][] setMagicSquare(int n) {
		
		// 마방진의 값을 저장할 2차원 배열
		int[][] square = new int[n][n];
		
		// 2차원 배열에 넣어줄 값이 되는 변수입니다.
		int value = 1;
		
		// 2차원 배열에서 어느 위치에 넣을건지 알려주는 변수입니다.
		int i = 0;
		int j = (n - 1) / 2;
		
		// 최상단 중앙에 1을 넣어주어 초기화합니다.
		square[i][j] = value;
		value++;
		
		// 2차원 배열이 채워질 때까지 반복합니다.
		while (value <= n * n) {
			
			// 현재의 배열 위치에서 로직에 의해서 다음 위치를 예상하여 저장하는 변수입니다.
			int k = (i - 1 < 0) ? (n - 1) : (i - 1);
			int l = (j - 1 < 0) ? (n - 1) : (j - 1);
			
			// 예측한 위치에 값이 없다면, 그 위치에 값을 넣어줍니다.
			// 예측한 위치에 값이 있다면, 현재 위치에서 하나 내려간 위치에 값을 넣어줍니다.
			if (square[k][l] != 0) {
				
				i = (i + 1) % n;
			} else {
				
				i = k;
				j = l;
			}
				
			// 실질적으로 값을 넣어주는 식입니다.
			square[i][j] = value;
			value++;
		}

		// 만들어진 2차원 배열의 마방진을 반환해줍니다.
		return square;
	}
	
	// 만들어진 2차원 배열의 마방진을 보여주는 함수입니다.
	private static void getMagicSquare(int[][] square) {
	
		for (int i = 0 ; i < square.length ; i++) {	
			for (int j = 0 ; j < square.length ; j++) {
				
				System.out.print(square[i][j] + " ");
			}
			
			System.out.println("");
		}
	}
}