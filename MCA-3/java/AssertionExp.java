import java.util.Scanner;
class AssertionExp{
	public static void main(String args[])
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter age :");
		int val = scn.nextInt();
		assert val >= 18 :"Not valid";
		System.out.println("Value = "+val);
	}
}