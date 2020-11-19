//import java.util.Scanner;
class ifdemo{
	public static void main(String[] args){
		int a,b,c;
		a = 2;
		b = 3;
		//Scanner obj = new Scanner(System.in);
		//System.out.println("Enter value for A :");
		//a = obj.nextInt();
		//System.out.println("Enter value for A :");
		//b = obj.nextInt();
		
		if(a < b)
			System.out.println("a is less than b..");
		else
			System.out.println("b is less than a..");
		System.out.println();
		
		c = a - b;//c contain -1
		System.out.println("c contain -1");
		if(c >= 0)
			System.out.println("c is positive..");
		if(c < 0)
			System.out.println("c is negative..");
		
		System.out.println();
		
		c = b - a;//c contain 1
		System.out.println("c contain 1");
		if(c >= 0)
			System.out.println("c is positive..");
		if(c < 0)
			System.out.println("c is negative..");
	}
}