import java.util.*;
import java.io.*;
import java.net.*;
public class exe3TCPServer{
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
			msg=msg.trim();
			String arr[]=msg.split(" ");
			msg="";
			String s1;
			int i;
			for(i=0;i<arr.length;i++){
				s1=arr[i];
				if(i!=0)
					s1=s1.replace(s1.charAt(0),Character.toUpperCase(s1.charAt(0)));
				msg+=s1;
			}
			msg=msg.replace(msg.charAt(0),Character.toLowerCase(msg.charAt(0)));
			
			
			OutputStream os=sc.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(msg);

			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}