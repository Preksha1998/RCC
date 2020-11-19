class scanner2
{
	public static void main(String[] args)
	{
		String s=System.console().readLine("\nEnter a String: ");
		
		if(!s.startsWith("//") && !s.startsWith("/*"))
		{
			System.out.println("\nInvalid Input");
		}
		else if(s.startsWith("/*") && !s.endsWith("*/"))
		{
			System.out.println("\nInvalid Input");
		}
		else
		{
			System.out.println("\nInput is Valid!");
		}
	}
}

/*
D:\MCA-III\SS>java scanner2

Enter a String: /*preksha*/

//Input is Valid!

/*D:\MCA-III\SS>java scanner2

Enter a String: /*scannerdemo

Invalid Input

D:\MCA-III\SS>java scanner2

Enter a String: //scannerdemo

Input is Valid!

D:\MCA-III\SS>java scanner2

Enter a String: //scanner//

Input is Valid!

D:\MCA-III\SS>java scanner2

Enter a String: /*scanner*/

//Input is Valid!
