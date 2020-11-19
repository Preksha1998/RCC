import java.util.*;

abstract class monster
{
	abstract void getdata();
}

class warewolf extends monster
{
	void getdata()
	{
		System.out.println("I'm WareWolf");
	}
}

class zombie extends monster
{
	void getdata()
	{
		System.out.println("I'm Zombie");
	}
}

class vampire extends monster
{
	void getdata()
	{
		System.out.println("I'm Vampire");
	}
}

public class a2_p8
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		monster[] m1=new monster[6];
		String mtype;
		
		for(int i=0; i<6; i++)
		{
			System.out.println("What type of monster you are? (warewolf/zombie/vampire): ");
			mtype=sc.nextLine();
			
			if(mtype.equals("warewolf"))
			{
				m1[i]=new warewolf();
			}
			else if(mtype.equals("zombie"))
			{
				m1[i]=new zombie();
			}
			else if(mtype.equals("vampire"))
			{
				m1[i]=new vampire();
			}
			else
			{
				System.out.println("\nYou're not a monster!");
			}
		}
		
		System.out.println("\n\nDisplaying Data:-\n");
		for(int i=0; i<6; i++)
		{
			m1[i].getdata();
		}
		
	}
}