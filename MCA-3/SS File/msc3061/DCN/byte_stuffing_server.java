import java.util.*;
import java.net.*;
import java.io.*;
public class byte_stuffing_server
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
				for(int i=1;i<len-1;i++)
				{
					if(msg.charAt(i)=='e')
					{
							cnt++;
							if(cnt==2)
							{
								str+=msg.charAt(i);
								cnt=0;
							}
					}
					else
					{
						str+=msg.charAt(i);
						cnt=0;
					}
					
				}
				System.out.println(" Final Message : "+str);
		}
		catch(Exception e){}
		
		
	}
}