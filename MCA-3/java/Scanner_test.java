import java.util.Scanner;
class Scanner_test{
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter your name, age, salary :");

		String name = scn.nextLine();

		int age = scn.nextInt();

		double salary = scn.nextDouble();

		System.out.println("Name = "+name);
		System.out.println("Age = "+age);
		System.out.println("Salary = "+salary);
	}
}