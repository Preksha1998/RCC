import java.util.Scanner;
class person{
	int age;
	float salary;
	String name;

	Scanner sc = new Scanner(System.in);
		
	void getdata()
	{
		System.out.println("Enter Name :");
		name = sc.nextLine();
		System.out.println("Enter Age :");
		age = sc.nextInt();
		System.out.println("Enter Salary :");
		salary = sc.nextFloat();	
	}
	

	void display()
	{
		System.out.println("\n\t\t**** DISPLAY DATA ****\n");
		System.out.println("Name = " +name);
		System.out.println("Age = " +age);
		System.out.println("Salary = " +salary);
	}
}

public class p10{
	public static void main(String args[]){

		person p = new person();
		p.getdata();
		p.display();
	}
}