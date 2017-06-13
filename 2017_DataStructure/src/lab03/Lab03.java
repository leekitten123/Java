package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab03 {

	class Data {
		
		String what;
		float x ;
		float y;
		
		public Data (String what, float x, float y) {
			this.what = what;
			this.x = x;
			this.y = y;
		}

		public float shape() {
			
			if (what.equals("triangle")) {
				return (x * y * 0.5f);
			} else if (what.equals("rectangle")) {
				return (x * y);
			} else if (what.equals("circle")){
				return (x * x * 3.14f);
			} else {
				return -1;
			}
				
		}
	}

	public void array() throws FileNotFoundException {
		
		Data[] data = new Data[7];

		File file = new File("/Users/leesangwook/Documents/workspace/DataStructure/src/lab03/Lab03.txt");
		Scanner scanner = new Scanner(file);

		for (int i = 0 ; i < 7 ; i++) {
		
			String temp = scanner.next();
			
			if (temp.equals("triangle")) {
				
				data[i] = new Data("triangle", scanner.nextFloat(), scanner.nextFloat());
				
			} else if (temp.equals("rectangle")) {
				
				data[i] = new Data("rectangle", scanner.nextFloat(), scanner.nextFloat());
				
			} else if (temp.equals("circle")) {
				
				data[i] = new Data("circle", scanner.nextFloat(), 0);	
			}
		}
			
		print(data);
		
		System.out.println();
		
		SelectionSort(data, data.length);
		print(data);
		
		scanner.close();
	}
	
	void SelectionSort(Data[] data, int MAX) {
		
		int i, j; 
		int min;
		
		Data temp;
    
		for(i=0; i<MAX-1; i++) {
        
			min = i;
			
			for(j=i+1; j<MAX; j++) {
            
				if((data[j].what.equals("triangle") && data[min].what.equals("rectangle"))) {
					min = j;
				} else if((data[j].what.equals("triangle") && data[min].what.equals("circle"))) {
					min = j;
				} else if((data[j].what.equals("rectangle") && data[min].what.equals("circle"))) {
					min = j;
				}	
			}
		
			temp = data[i];
			data[i] = data[min];
			data[min] = temp;
			
			} 
		}
	
	void print(Data[] data) {
		
		for (int i = 0 ; i < data.length ; i++) {
			
			if (data[i].what.equals("triangle")) {
				
				System.out.println(data[i].what + " " + data[i].x +  " " + data[i].y + " " + data[i].shape());
				
			} else if (data[i].what.equals("rectangle")) {
				
				System.out.println(data[i].what + " " + data[i].x +  " " + data[i].y + " " + data[i].shape());
				
			} else if (data[i].what.equals("circle")) {
				
				System.out.println(data[i].what + " " + data[i].x +  " " + data[i].shape());	
			}
		}
	}
}