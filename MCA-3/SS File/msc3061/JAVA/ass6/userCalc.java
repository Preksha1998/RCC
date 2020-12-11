import calculator.addition;
import calculator.substraction;
import calculator.multiplication;
import calculator.divison;
import java.util.*;
class userCalc{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER 2 NUMBERS::");
		int no1=sc.nextInt();
		int no2=sc.nextInt();
		System.out.println("ENTER 1 FOR ADDITION");
		System.out.println("ENTER 2 FOR SUBSTRACTION");
		System.out.println("ENTER 3 FOR MULTIPLICATION");
		System.out.println("ENTER 4 FOR DIVISON");
		System.out.println("ENTER 5 FOR EXIT");
		System.out.println("ENTER YOUR CHOICE::");
		int n=sc.nextInt();
		switch(n){
			case 1:
				addition a=new addition();
				a.add(no1,no2);
				break;

			case 2:
				substraction s=new substraction();
				s.sub(no1,no2);
				break;

			case 3:
				multiplication m=new multiplication();
				m.mul(no1,no2);
				break;

			case 4:
				divison d=new divison();
				d.div(no1,no2);
				break;

			case 5:
				
				break;
		}
	}
}