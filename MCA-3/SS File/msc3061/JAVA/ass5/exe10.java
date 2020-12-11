import java.util.*;
import java.io.*;
class exe10{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a::");
		int a=sc.nextInt();
		System.out.println("enter b::");
		int b=sc.nextInt();
		try{
			if(b==0){
				throw new CustomException("divide by 0");
			}
			else{
				System.out.println("output is::"+(a/b));
			}
		}
		catch(CustomException e){
				System.out.println(e);
		}
	}
}
class CustomException extends Exception{
	CustomException(String msg){
		super(msg);
	}
}