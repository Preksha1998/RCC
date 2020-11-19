import java.util.*;

class jaggedArray {
	public static void main(String[] args) {
		int arr[][] = new int[2][];
		
		//first row has three columns
		arr[0]= new int[3];
		
		//secound row has 2 columns
		arr[1] =new int[2];
		
		int count =0;
		for(int i=0;i<arr.length; i++)
		{
			for(int j=0;j<(arr[i].length); j++)
			{
				arr[i][j] = count++;
			}
		}			
		System.out.println("Contents of 2D jagged Array");
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	
	}
}