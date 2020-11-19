import java.util.Scanner;
public class p7{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Positive Number For Factors:");

		int no = sc.nextInt();

		System.out.print("Factors = ");
		for(int i = 1; i <= no; i++)
		{
			if(no % i == 0)
			{
				System.out.print(i + "  ");
			}
		}
	}
}