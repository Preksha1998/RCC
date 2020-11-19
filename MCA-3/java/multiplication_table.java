import java.io.IOException;
//import java.util.Scanner;

class multiplication_table{
	public static void main(String[] args) {
		int n;
		System.out.println("Enter no. u want to generate the table : ");
		try{
			n = System.in.read();
			System.out.print("You entered :");
			System.out.println(n);
		}
		catch (IOException e){
			System.out.println("Error reading from user..");
		}
	}
}