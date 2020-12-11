package Number_System;
import java.util.*;
public class stringoperation{
	public void sort(){
		char arr[]={'H','E','T','V','E','E'};
		
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					char temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println("The Values After Sorting Is::");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]+" ");
		}


	}
	public void rev(){
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE STRING::");
		String s=sc.nextLine();
		StringBuffer s1=new StringBuffer(s);
		System.out.println("REVERSE IS::"+s1.reverse());
	}
}
