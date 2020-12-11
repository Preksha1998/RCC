import java.util.*;
class node
{
	node lc,rc;
	String v;
	node()
	{
		v=null;
		lc=null;
		rc=null;
	}
	node(String a,node b,node c)
	{
		v=a;
		lc=b;
		rc=c;
	}
	void display()
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
public class rdp2
{
	static int c=0;
	public static void main(String args[])
	{
		String s;
		node root=new node();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter expression: ");
		s=sc.next();
		if(s.charAt(0)=='+' || s.charAt(0)=='*')
		{
			System.out.println("Invalid Expression!");
		}
		else
		{
		root=pe(s);
		if(root==null || c!=s.length())
		{
			System.out.println("Invalid Expression!");
		}
		else
		{
			root.display();
		}
		}
	}
	public static node pe(String exp)
	{
		node a,b;
		a=pt(exp);
		while(c<exp.length() && exp.charAt(c)=='+')
		{
			c++;
			b=pt(exp);
			if(b!=null)
			{
				a=new node("+",a,b);
			}
			else
			{
				return null;
			}
		}
		return a;
	}
	public static node pt(String exp)
	{
		node a,b;
		a=pv(exp);
		while(c<exp.length() && exp.charAt(c)=='*')
		{
			c++;
			b=pv(exp);
			if(b!=null)
			{
				a=new node("*",a,b);
			}
			else
			{
				return null;
			}
		}
		return a;
	}
	public static node pv(String exp)
	{
		node a;
		if(c<exp.length() && exp.charAt(c)!='+' && exp.charAt(c)!='*')
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