class a2_p11_b
{
	public static void main(String[] args)
	{
		int count=0;
		String org=System.console().readLine("\nEnter a String: ");
		String[] arr=org.split(" ");
		
		String find=System.console().readLine("\nEnter a string to find total occurrences: ");
		String rev = new StringBuffer(find).reverse().toString();
		
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i].equals(find))
			{
				count++;
			}
		}
		
		System.out.println("\nThe word " + find + " occurs total " + count + " times.");
		System.out.println("\nReversed String: " + rev);
	}
		
}

/*
Output:-

Enter a String: Quick Brown ABC Fox ABC Jumps Over ABC

Enter a string to find total occurrences: ABC

The word ABC occurs total 3 times.

Reversed String: CBA

*/