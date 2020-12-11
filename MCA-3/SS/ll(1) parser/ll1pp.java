import java.util.*;
import java.io.*;
class ll1pp
{
	public static void main(String args[])
	{
		ll1 obj=new ll1();
		try
		{
		obj.inittable();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		obj.showtable();
		obj.getexp();
		obj.parseexp();
	}
}
class ll1
{
	String exp;
	String rarr[][]=new String[6][5];
	void getexp()
	{
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter exp: ");
			exp=sc.next();
			exp=exp+"|";
	}
	void inittable() throws Exception
	{
		BufferedReader br=new BufferedReader(new FileReader("ruleTable.txt"));
		String arr[],line=br.readLine();
		int i=0;
		while(line!=null){
			arr=line.split("\t");
			for(int j=0;j<arr.length;j++)
				rarr[i][j]=arr[j];
			i++;
			line=br.readLine();
		}
		br.close();
	}
	
	void showtable()
	{
			System.out.println("Rule Table");
			for(int i=0;i<rarr.length;i++)
			{
				for(int j=0;j<rarr[i].length;j++)
				{
					System.out.print(rarr[i][j]+"\t");
				}
				System.out.print("\n");
			}
	}
	
	void parseexp()
	{
		int ssm=0;
		String csf="",newr;
		if(exp.charAt(ssm)=='a')
		{
			newr=getnextrule(rarr[1][0],exp.charAt(0)+"");
			csf=newr+csf;
			System.out.println("\nCSF \t\t Symbol \t Prediction \n________________________________________________\n");
			
			while(ssm<exp.length())
			{
				System.out.println(csf+" \t\t "+exp.charAt(ssm) +" \t\t "+newr);
				newr=getnextrule((csf.charAt(0)+""),exp.charAt(ssm)+"");
				if(newr==null)
				{
					System.out.println("!!! INVALID exp !!!");
					return;
				}
				
				csf=new StringBuilder(csf).deleteCharAt(0).toString();
				csf=newr+csf;
				
				if((csf.charAt(0)+"").equals(exp.charAt(ssm)+""))
				{
					csf=new StringBuilder(csf).deleteCharAt(0).toString();
					ssm++;
				}
				if((newr.equals("e")))
				{
					csf=new StringBuilder(csf).deleteCharAt(0).toString();
				}
				if(csf.equals(""))
				{
					System.out.println("\n_______________________\n exp IS VALID \n_______________________");
					return;
				}
			}
			System.out.println("Invalid exp!");
		}
		else
		{
			System.out.println("!!! INVALID exp !!!");
		}
	}
	
	String getnextrule(String r,String c)
	{
		boolean row=false,col=false;
		int i,j;
		for(i=1;i<rarr.length;i++)
		{
			if(rarr[i][0].equals(r))
			{
				row=true;
				break;
			}
		}
		for(j=1;j<rarr[0].length;j++)
		{
			if(rarr[0][j].equals(c))
			{
				col=true;
				break;
			}
		}
		if(row && col)
		{
			return rarr[i][j];
		}
		else
		{
			return null;
		}
	}
}