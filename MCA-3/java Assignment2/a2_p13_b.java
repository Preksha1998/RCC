class a2_p13_b{
	public static void main(String args[])
	{
		int i,j;
		for(i = 0; i <= 5; i++)
		{
			for(j = 0 ; j <= i; j++)
			{
				if(j % 2 == 0)
				{
					System.out.print("1");
				}
				else
				{
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}
}