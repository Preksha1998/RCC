import java.util.*;
import java.io.*;
import java.net.*;
public class exe4TCPServer{
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
			char str[]=msg.toCharArray();
			msg="";
			for(int i=0;i<str.length;i++){
			if(Character.isUpperCase(str[i])){
				msg+=Character.toLowerCase(str[i]);
			}
			else{
				msg+=Character.toUpperCase(str[i]);
			}
			}
			
			OutputStream os=sc.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(msg);

			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}