import student.personnal_details;
import student.studentMarks.result;
import java.util.*;
class exe4{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER 1 FOR STUDENT'S PERSOONAL DETAILS");
		System.out.println("ENTER 2 FOR STUDENT'S RESULT");
		System.out.println("ENTER 3 FOR EXIT");
		System.out.println("ENTER YOUR CHOICE::");
		int i;
		i=sc.nextInt();
		
		switch(i){
			case 1:
				personnal_details p=new personnal_details();
				p.details();
				break;
			case 2:
				result r=new result();
				r.displayResult();
				break;
			case 3:
				break;
		}
	}
}