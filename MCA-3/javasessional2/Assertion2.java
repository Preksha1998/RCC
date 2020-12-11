import java.util.Scanner;

class Assertion2{
	public static void main(String args[]) throws java.io.IOException
	{	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Your Age ");
		int value = scanner.nextInt();
		
		assert value>=18 : "Not Valid";
		System.out.println("Value:" + value);
	}
}