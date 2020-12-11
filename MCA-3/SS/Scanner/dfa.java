import java.util.*;
import java.lang.*;
import java.io.*;
class op
{
	String arr[][]=new String[5][5];
	
	public void inittable() throws IOException
	{
		FileReader fr=new FileReader("states3.txt");
		BufferedReader br=new BufferedReader(fr);
		String line;
		String c;
		int i;
		int j=0;
		while((line=br.readLine())!=null)
		{
			String brr[]=line.split("\t");
			for(i=0;i<brr.length;i++)
			{
				c=(String)line.split("\t")[i];
				arr[j][i]=c;
			}
			j++;
		}
		for(i=0;i<arr.length;i++)
		{
			for(j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public String nextstate(String curs,String c)
	{
		int i,j,r=-1,cc=-1;
		for(i=0;i<arr.length;i++)
		{
			if(curs.equals(arr[i][0]))
			{
				r=i;
				break;
			}
		}
		for(i=0;i<arr[0].length;i++)
		{
			if(c.equals(arr[0][i]))
			{
				cc=i;
				break;
			}
		}
		return arr[r][cc];
	}
	public void scan(String str)
	{
		String curs=arr[1][0],c,nexts=null;
		for(int i=0;i<str.length();i++)
		{
			c=(str.charAt(i))+"";
			nexts=nextstate(curs,c);
			if(nexts==null || (nexts.equals("-")))
			{
				System.out.println("\nInvalid Expression!");
				return;
			}
			curs=nexts;
		}
		if(curs.equals("D"))
		{
			System.out.println("Expression is valid!");
		}
		else
		{
			System.out.println("\nInvalid Expression!");
		}
	}
}
public class dfa
{
	public static void main(String args[])
	{
		String str=null;
		Scanner sc=new Scanner(System.in);
		try
		{
			op o=new op();
			o.inittable();
			System.out.println("Enter String: ");
			str=sc.next();
			o.scan(str);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}