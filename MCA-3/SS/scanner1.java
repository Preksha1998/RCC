class scanner1
{
	static boolean containsLetter(String s)
	{
		for(int x=0; x<s.length(); x++)
		{
			for(int y='A'; y<='Z'; y++)
			{
				if(s.toUpperCase().charAt(x)==y)
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		String s=System.console().readLine("\nEnter a String: ");
		
		if(s.startsWith(".") || s.endsWith("."))
		{
			System.out.println("\nInvalid Input");
		}
		else if(Character.isDigit(s.charAt(0)) && containsLetter(s))
		{
			System.out.println("\nInvalid Input");
		}
		else
		{
			System.out.println("\nInput is Valid!");
		}
		
	}
}