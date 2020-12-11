import java.util.*;
class node
{
	node lc,rc;
	String v;
	node()
	{
		v="";
		lc=null;
		rc=null;
	}
	node(String a,node b,node c)
	{
		v=a;
		lc=b;
		rc=c;
	}
	public void display()
	{
		if(lc!=null)
		{
			lc.display();
		}
		if(rc!=null)
		{
			rc.display();
		}
		System.out.print(v);
	}
}
public class rdp
{
	public static int c=0;
	public static void main(String args[])
	{
		String exp;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Expression: ");
		exp=sc.next();
		node root=new node();
		if(exp.charAt(0)=='-' || exp.charAt(0)=='/')
		{
			System.out.println("Invalid Expression!");
		}
		else
		{
			root=procE(exp);
			if(root==null || c!=exp.length())
			{
				System.out.println("Invalid expression!");
			}
			else{
				root.display();
			}
		}
	}
	public static node procE(String exp)
	{
		node a,b;
		a=procT(exp);
		while(c<exp.length() && exp.charAt(c)=='-')
		{
				c++;
				b=procT(exp);
				if(b!=null)
				{
					a=new node("-",a,b);
				}
				else
				{
					return null;
				}
		}
		return a;
	}
	public static node procT(String exp)
	{
		node a,b;
		a=procV(exp);
		while(c<exp.length() && exp.charAt(c)=='/')
		{
			c++;
			b=procV(exp);
			if(b!=null)
			{
				a=new node("/",a,b);
			}
			else
			{
				return null;
			}
		}
		return a;
	}
	public static node procV(String exp)
	{
		node a;
		if(c<exp.length() && exp.charAt(c)!='-' && exp.charAt(c)!='/')
		{
			a=new node(exp.charAt(c)+"",null,null);
			c++;
		}
		else{
			return null;
		}
		return a;
	}
}