import java.util.*;
import java.io.*;
import java.net.*;
public class exe2ass1TCPServer{
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
			int i,flag=0;
			int num=Integer.parseInt(msg.trim());
			for(i=2;i<=(num/2);i++){
			if(num%i==0){
				msg="Not Prime";
				flag=1;
				break;
			}
		}
		if(flag==0){
			msg="Is Prime";

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