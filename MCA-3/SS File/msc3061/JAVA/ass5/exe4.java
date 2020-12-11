import java.util.*;
class exe4{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String fname,lname,bday;
		StringBuffer sb=new StringBuffer();
		System.out.println("enter first name::");
		fname=sc.nextLine();
		System.out.println("enter last name::");
		lname=sc.nextLine();
		System.out.println("enter birthdate::");
		bday=sc.nextLine();
		//System.out.println("enter birthdate::");
		//sb=sc.nextLine();
		String day[]=new String[3];
		day=bday.split("/");
		System.out.println("Name::"+fname+" "+lname);
		System.out.println("Birthdate::");
		System.out.println("Day::"+day[0]);
		System.out.println("Month::"+day[1]);
		System.out.println("Year::"+day[2]);

		/*day=sb.split("/");
		System.out.println("Name::"+fname+" "+lname);
		System.out.println("Birthdate::");
		System.out.println("Day::"+day[0]);
		System.out.println("Month::"+day[1]);
		System.out.println("Year::"+day[2]);*/



	}

}