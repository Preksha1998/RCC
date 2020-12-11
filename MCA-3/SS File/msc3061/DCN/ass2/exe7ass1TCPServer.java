import java.util.*;
import java.io.*;
import java.net.*;
public class exe7ass1TCPServer{
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
			int num=Integer.parseInt(msg.trim());
			int sum=0;
			for(int i=1;i<num;i++){
				if(num%i==0){
					sum+=i;
				}
			}
		if(sum==num){
			msg="Perfect";
		}
		else{
			msg="Not Perfect";
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