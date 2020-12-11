import java.util.*;
import java.net.*;
import java.io.*;
public class byte_stuffing_clinet
{
	public static void main(String args[])
	{
		try
		{
				Socket s=new Socket("localhost",81);
				DataInputStream dis=new DataInputStream(s.getInputStream());
				DataOutputStream dos=new DataOutputStream(s.getOutputStream());
				Scanner sc=new Scanner(System.in);
				System.out.println("Please enter a String");
				String msg=sc.nextLine();
				String flag="f";
				String m="";
				int cnt=0;
				int len=msg.length();
				for(int i=0;i<len;i++)
				{
					if(msg.charAt(i)=='e' || msg.charAt(i)=='f')
					{
						m+='e';
					}
					m+=msg.charAt(i);
				}
				m=flag+m+flag;
				System.out.println("String to be Sent : "+m);
				dos.writeUTF(m);
		}
		catch(Exception e){}
		
	}
}