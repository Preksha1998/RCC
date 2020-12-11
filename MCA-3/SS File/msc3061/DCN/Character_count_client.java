import java.util.*;
import java.net.*;
import java.io.*;
public class Character_count_client
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
				dos.writeUTF(msg);
				msg=dis.readUTF();
				System.out.println("message from server  : "+msg);
				int len=msg.length();
				if(len>10)
				{
					msg=msg.substring(2,len);
				}
				else if(len>100)
				{
					msg=msg.substring(3,len);
				}
				else
				{
					msg=msg.substring(1,len);
				}
				System.out.println("Final String : "+msg);
		}
		catch(Exception e){}
		
	}
}