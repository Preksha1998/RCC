import java.util.*;
class stringreverse{
	public void rev(String str){
		char arr[]=str.toCharArray();
		String str1="";
		System.out.println("The Value Is::");
		for(int i=arr.length-1;i>=0;i--){
			System.out.println(arr[i]+" ");
			str1+=arr[i];
		}
		System.out.println("String After Reverse Is::"+str1);


	}
}
public class stringrev{
	public static void main(String args[]){
		stringreverse s=new stringreverse();
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE STRING::");
		s.rev(sc.nextLine());
	}
}

