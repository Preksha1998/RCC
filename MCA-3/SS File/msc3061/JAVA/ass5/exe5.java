import java.util.*;
class exe5{
	public static void main(String args[]){
		StringBuffer str=new StringBuffer("Hetvee");
		System.out.println("Original String Is::"+str);
		str.insert(6,"shah");
		System.out.println("After Insertion::"+str);	
		System.out.println("Appending A string::"+str.append("SHAH"));
		System.out.println("Reverse Of The String::"+str.reverse());
		System.out.println("Deletion Of String::"+str.delete(0,3));

		//String str1="Hetvee";
		//System.out.println("Original String Is::"+str1);
		//str1.insert(6,"shah");
		//System.out.println("After Insertion::"+str1);	
		//System.out.println("Appending A string::"+str1.append("SHAH"));
		//System.out.println("Reverse Of The String::"+str1.reverse());
		//System.out.println("Deletion Of String::"+str1.delete(0,3));
		
		
	}

}