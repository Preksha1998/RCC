import java.util.*;
class strbuffer_exe1{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 for substring");
		System.out.println("Enter 2 for length of the string");
		System.out.println("Enter 3 for find char at 5th position");
		int op;
		op=sc.nextInt();
		StringBuffer str=new StringBuffer("HetveeShah");
		switch(op){
			case 1:
			  System.out.println("substring is::"+str.substring(0,3));
			  break;
			case 2:
			  System.out.println("length is::"+str.length());
			  break;
			case 3:
			  System.out.println("char at 5th index is::"+str.charAt(5));
			  break;
			case 4:
			  break;
		}
	}
}