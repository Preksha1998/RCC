import java.util.Scanner;
public class p9{
	public static void main(String args[]){
		int no = Integer.parseInt(args[0]);
		for(int i = no ; i >= 0; i--)
		{
			System.out.println(no);
			no--;
			if(no == 0)
			{
				System.out.print("\007");//for beep sound
			}
		}

	}
}