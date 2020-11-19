import java.util.Scanner;
class a2_p1{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int r,c,i,j,r1,c1;

		System.out.println("Enter rows and colmns for 1st Matrix:");
		System.out.print("Enter Rows :");
		r = sc.nextInt();
		System.out.print("Enter Cols :");
		c = sc.nextInt();

		System.out.println("Enter rows and colmns for 2nd Matrix:");
		System.out.print("Enter Rows :");
		r1 = sc.nextInt();
		System.out.print("Enter Cols :");
		c1 = sc.nextInt();

		if(r == r1 && c == c1)
		{
			int first[][] = new int[r][c];//declare matrix
			int second[][] = new int[r1][c1];
			int add[][] = new int[r1][c1];

			System.out.println("Enter Elements for Matrix 1 :");
			for(i = 0; i < r; i++)
			{
				for(j = 0; j < c; j++)
				{
					first[i][j] = sc.nextInt();
				}
			}

			System.out.println("Enter Elements for Matrix 2 :");
			for(i = 0; i < r1; i++)
			{
				for(j = 0; j < c1; j++)
				{
					second[i][j] = sc.nextInt();
				}
			}	
			
			System.out.println(" \t\t: Matrix 1 :");
			for(i = 0; i < r; i++)
			{
				for(j = 0; j < c; j++)
				{
					System.out.print(first[i][j] + "   ");
				}
				System.out.println();
			}

			System.out.println(" \t\t: Matrix 2 :");
			for(i = 0; i < r; i++)
			{
				for(j = 0; j < c; j++)
				{
					System.out.print(second[i][j] + "   ");
				}
				System.out.println();
			}	
			for(i = 0; i < r; i++)
			{
				for(j = 0; j < c1; j++)
				{
					for(int k = 0; k < c; k++)
					{
						add[i][j] = first[i][j] + second[i][j];
					}
				}
			}
			System.out.println("\t\t*** Matrix After Addition ***\n");
			for(i = 0; i < r; i++)
			{
				for(j = 0; j < c; j++)
				{
					System.out.print(add[i][j] + "  ");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("Enter same rows and cols for both matrix..!");
		}
	}
}