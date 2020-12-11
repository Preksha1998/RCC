import java.util.*;
import java.io.*;
import java.net.*;
public class exe1ass1TCPServer{
	public static void main(String args[]){
		try{
			String msg="";
			ServerSocket ss=new ServerSocket(81);
			Socket sc=ss.accept();
			Scanner s=new Scanner(System.in);
			InputStream is=sc.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			msg=(String)dis.readUTF();
			System.out.println("Message From Client is::"+msg.trim());
			int n=Integer.parseInt(msg.trim());
			int fact=1;
			for(int i=1;i<=n;i++)
			fact*=i;
			msg=Integer.toString(fact);
			
			OutputStream os=sc.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(msg);

			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}