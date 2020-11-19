import java.util.*;

public class a2_p12_a 
{
   public static void main(String[] args)
   {	 
	long b1, b2;
	int i = 0, carry = 0;

	int[] sum = new int[10];

	Scanner scanner = new Scanner(System.in);

	System.out.print("\nEnter first binary number: ");
	b1 = scanner.nextLong();

	System.out.print("\nEnter second binary number: ");
	b2 = scanner.nextLong();

	while (b1 != 0 || b2 != 0) 
	{
		sum[i++] = (int)((b1 % 10 + b2 % 10 + carry) % 2);
		carry = (int)((b1 % 10 + b2 % 10 + carry) / 2);
		b1 = b1 / 10;
		b2 = b2 / 10;
	}
	if (carry != 0) 
	{
		sum[i++] = carry;
	}
	--i;
	
	System.out.print("\nOutput: ");
	
	while (i >= 0) 
	{
		System.out.print(sum[i--]);
	}
	
	System.out.print("\n");  
   }
}
