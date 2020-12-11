package student.studentMarks;
import java.util.*;
public class result{
	public void displayResult(){
		int total=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER RESULT OF THREE SUBJECTS::");
		int mark[]=new int [3];
		for(int i=0;i<3;i++){
			mark[i]=sc.nextInt();
		}
		

		for(int i=0;i<3;i++){
			total+=mark[i];
		}
		System.out.println("TOTAL RESULT IS::"+total);
	}
}