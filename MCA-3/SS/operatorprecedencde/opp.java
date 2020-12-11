import java.io.*;
import java.util.*;

class node
{
	String v;
	node lc,rc;
	node(){
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
class stack
{
	static int top=-1;
	String op;
	node opn;
	public void push(String a,node b)
	{
		op=a;
		opn=b;
	}
}
public class opp
{
	static String pt[][];
	static node root;
	public static void main(String args[])throws Exception
	{
		filltable();
		showtable();
		Scanner sc=new Scanner(System.in);
		String exp;
		System.out.println("Enter Expression: ");
		exp=sc.next();
		exp="|"+exp+"|";
		String op,opn;
		int ssm=0,r=0,c=0;
		stack st[]=new stack[10];
		op=exp.charAt(ssm++)+"";
		opn=exp.charAt(ssm)+"";
		node n=new node(opn,null,null);
		st[++stack.top]=new stack();
		st[stack.top].push(op,n);
		String str;
		boolean error=false;
		while(exp.charAt(ssm)!='|')
		{
			ssm++;
			r=getr(st[stack.top].op);
			c=getc(exp.charAt(ssm)+"");
			if(r!=-1 && c!=-1)
			{
				str=pt[r][c];
			}
			else
			{
				System.out.println("Invalid Expression: ");
				error=true;
				break;
			}
			if(str.equals("<"))
			{
				op=exp.charAt(ssm++)+"";
				opn=exp.charAt(ssm)+"";
				n=new node(opn,null,null);
				st[++stack.top]=new stack();
				st[stack.top].push(op,n);
			}
			else if(str.equals(">"))
			{
				pop(st);
				ssm--;
			}
		}
		if(!error)
		{
			root=st[stack.top].opn;
			System.out.println("Postorder Expression: ");
			root.display();
		}
	}
	public static void filltable()throws Exception
	{
		int i=0,j;
		BufferedReader br=new BufferedReader(new FileReader("OpePreTable.txt"));
		String line=null;
		pt=new String[6][6];
		while((line=br.readLine())!=null && i<6)
		{
			String arr[]=line.split("\t");
			for(j=0;j<arr.length;j++)
			{
				pt[i][j]=arr[j];
			}
			i++;
		}
		br.close();
	}
	public static void showtable()
	{
		int i,j;
		for(i=0;i<pt.length;i++)
		{
			for(j=0;j<pt[i].length;j++)
			{
				System.out.print(pt[i][j]+"\t");
			}
			System.out.println("");
		}
	}
	public static int getr(String a)
	{
		int i;
		for(i=0;i<pt.length;i++)
		{
			if(pt[i][0].equals(a))
			{
				return i;
			}
		}
		return -1;
	}
	public static int getc(String b)
	{
		int i;
		for(i=0;i<pt[0].length;i++)
		{
			if(pt[0][i].equals(b))
			{
				return i;
			}
		}
		return -1;
	}
	public static void pop(stack st[])
	{
		String op1,op2;
		node opn1,opn2;
		op1=st[stack.top].op;
		opn1=st[stack.top--].opn;
		op2=st[stack.top].op;
		opn2=st[stack.top--].opn;
		node n=new node(op1,opn2,opn1);
		st[++stack.top].push(op2,n);
	}
}