class a2_p9
{
	public static void main(String[] args)
	{
		int flag=0,count=0;
		String org=System.console().readLine("Enter a String: ");
		String[] arr=org.split(" ");
		
		String find=System.console().readLine("Enter a string to print next 3 words: ");
		
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i].equals(find))
			{
				flag=1;
			}
			
			if(flag==1 && count<3)
			{
				System.out.println("\nString " + (count+1) + ": " + arr[i]);
				count++;
			}
		}
		
	}
}