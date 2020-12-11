import java.util.*;
import java.io.*;
import java.net.*;
public class exe4ass1TCPClient{
	public static void main(String args[]){
		try{
			
			Socket sc=new Socket("localhost",81);
			Scanner s=new Scanner(System.in);
			System.out.println("ENTER A STRING::");
			String msg=s.nextLine();
			OutputStream os=sc.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(msg);

			InputStream is=sc.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			msg=(String)dis.readUTF();
			System.out.println("String is::"+msg.trim());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}