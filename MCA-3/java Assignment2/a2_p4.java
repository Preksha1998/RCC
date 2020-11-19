/*

4.Write a program to remove duplicate characters from the string.

*/

class a2_p4
{
	public static void main(String[] args)
	{
		String name=System.console().readLine("Enter a String: ");
		char[] arr=name.toCharArray();
		char[] newstr=new char[50];
		int ctr=0;
		
		for(int i=0; i<arr.length; i++)
		{
			int flag=0;
			for(int j=0; j<i; j++)
			{
				if(arr[i]==arr[j])
				{
					flag=1;
				}
			}
			
			if(flag==0)
			{
				newstr[ctr]=arr[i];
				ctr++;
			}
		}
		
		String str=new String(newstr);
		System.out.println("\nFinal String: " + str);
	}
}

/*
Output:-

Enter a String: RuuttwwiikkR

Final String: Rutwik

*/

