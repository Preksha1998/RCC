import java.util.*;
class exe1{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 for substring with string function");
		System.out.println("Enter 2 for length of the string with string function");
		System.out.println("Enter 3 for find char at 5th position with string function");
		System.out.println("Enter 4 for substring with string buffer function");
		System.out.println("Enter 5 for length of the string with string buffer function");
		System.out.println("Enter 6 for find char at 5th position with string buffer function");
		int op;
		System.out.println("Enter The Choice::");
		op=sc.nextInt();
		String str=new String("HetveeShah");
		StringBuffer str1=new StringBuffer("HetveeShah");
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
			  System.out.println("substring is::"+str1.substring(0,3));
			  break;
			case 5:
			  System.out.println("length is::"+str1.length());
			  break;
			case 6:
			  System.out.println("char at 5th index is::"+str1.charAt(5));
			  break;
			case 7:
			  break;
		}
	}
}