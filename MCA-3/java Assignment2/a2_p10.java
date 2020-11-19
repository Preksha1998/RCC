import java.util.*;

class a2_p10
{
	public static void main(String[] args)
	{
		int years=0,days=0,min;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter minutes: ");
		min=sc.nextInt();
		
		days=min/1440; // 1 Day= 1440 mins
		
		while(days>=365)
		{
			years++;
			days=days-365;
		}
		
		System.out.println("\n" + years + " years and " + days + " days");
	}
}

/*
Output:-

Enter minutes: 3456789

6 years and 210 days

*/