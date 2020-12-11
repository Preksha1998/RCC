import java.util.*;
import java.net.*;
import java.io.*;
public class bit_stuffing_clinet
{
	public static void main(String args[])
	{
		try
		{
				Socket s=new Socket("localhost",81);
				DataInputStream dis=new DataInputStream(s.getInputStream());
				DataOutputStream dos=new DataOutputStream(s.getOutputStream());
				Scanner sc=new Scanner(System.in);
				System.out.println("Please enter a code in binary");
				String msg=sc.nextLine();
				String flag="01111110";
				String m="";
				int cnt=0;
				int len=msg.length();
				for(int i=0;i<len;i++)
				{
					if(msg.charAt(i)=='1')
					{
						cnt++;
						m+=msg.charAt(i);
					}
					if(cnt==5)
					{
						m+="0";
						cnt=0;
					}
				}
				m=flag+m+flag;
				System.out.println("String to be Sent : "+m);
				dos.writeUTF(m);
		}
		catch(Exception e){}
		
	}
}