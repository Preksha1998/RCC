//import java.lang.*;
import java.util.Scanner;

public class p1{ 
	public static void main(String args[]){
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Number :");

		int n = scn.nextInt();
		
		int i,j;
		for(i = 2; i <= n; i++)
		{
			for(j = 2; j <= i; j++)
			{
				if(i % j == 0)
				{
					break;
				}
			}

			if(i == j)
			{
				System.out.print(i + "  ");
			}
		}
	}
}