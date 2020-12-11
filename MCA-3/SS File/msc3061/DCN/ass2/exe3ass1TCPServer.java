import java.util.*;
import java.io.*;
import java.net.*;
public class exe3ass1TCPServer{
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
			int rev=0,flag=0;
			int num=Integer.parseInt(msg.trim());
			int num1=num;
			while(num>0){
				rev=(rev*10)+(num%10);
				num=num/10;
			}
			if(num1==rev){
				msg="pellingdrome";
			}
			else{
				msg="not pellingdrome";
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