import java.util.*;
import java.net.*;
import java.io.*;
public class Character_count_server
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
				msg=msg.length()+msg;
				dos.writeUTF(msg);
		}
		catch(Exception e){}
		
		
	}
}