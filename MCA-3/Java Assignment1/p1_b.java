public class p1_b{
	public static void main(String args[])
	{
		int i = 2;
		System.out.print("Prime Numbers : ");
		while(i <= 50)
		{
			int j= 2;
			while(j <= i)
			{
				if(i % j == 0)
				{
					break;
				}
				j++;
			}
			if(i == j)
			{
				System.out.print(i + "  ");
			}
			i++;
		}
	}
}