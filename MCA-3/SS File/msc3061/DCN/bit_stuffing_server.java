import java.util.*;
import java.net.*;
import java.io.*;
public class bit_stuffing_server
{
	public static void main(String args[])
	{
		try
		{
				ServerSocket ss=new ServerSocket(81);
				Socket s=ss.accept();
				DataInputStream dis=new DataInputStream(s.getInputStream());
				DataOutputStream dos=new DataOutputStream(s.getOutputStream());
				String msg=dis.readUTF();
				System.out.println("Message From Client  : "+msg);
				int len=msg.length();
				String str="";
				int cnt=0; 
				for(int i=8;i<len-8;i++)
				{
					if(msg.charAt(i)=='1')
					{
						cnt++;
						str+=msg.charAt(i);
					}
					if(msg.charAt(i)=='0')
					{
						if(cnt!=5)
						{
							str+=msg.charAt(i);
						}
						else
						{
							cnt=0;
						}
					}
				}
				System.out.println(" Final Message : "+str);
		}
		catch(Exception e){}
		
		
	}
}