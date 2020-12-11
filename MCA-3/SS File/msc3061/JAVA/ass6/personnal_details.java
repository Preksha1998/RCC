package student;
import java.util.*;
public class personnal_details{
	public void details(){
		Scanner sc=new Scanner(System.in);
		String name,DOB,address;
		System.out.println("ENTER YOUR NAME:");
		name=sc.nextLine();
		System.out.println("ENTER YOUR DOB:");
		DOB=sc.nextLine();
		System.out.println("ENTER YOUR ADDRESS:");
		address=sc.nextLine();
		System.out.println("ENTERED NAME IS::"+name);
		System.out.println("ENTERED DOB IS::"+DOB);
		System.out.println("ENTERED ADDRESS IS::"+address);
	}
}