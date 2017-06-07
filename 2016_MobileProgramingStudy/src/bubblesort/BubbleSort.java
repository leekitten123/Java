package bubblesort;

public class BubbleSort {

	public static void main(String[] args) {

		int Array[] = {7, 3, 8, 5, 9, 2, 5, 1} ;
		
		for (int j = 0 ; j < Array.length - 1 ; j ++)
		{
			for (int i = 0 ; i < Array.length - 1 ; i++)
			{
				if (Array[i] > Array[i + 1])
				{
					int tmp = Array[i + 1] ;
					Array[i + 1] = Array[i] ;
					Array[i] = tmp ;	
				}
			}
		}
		
		for (int j = 0 ; j < Array.length ; j++)
		{

			System.out.println(Array[j]);
		}
	}
}