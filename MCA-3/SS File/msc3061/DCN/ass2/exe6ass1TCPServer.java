import java.util.*;
import java.io.*;
import java.net.*;
public class exe6ass1TCPServer{
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
			int steps=Integer.parseInt(msg.trim());
			int i=0,j=1,sum=0;
			if(steps==1){
				msg="0 ";
			}
			else if(steps==2){
				msg="0 1 ";
			}
			else{
			msg="0 1 ";
			while(steps>2){
				
				sum=i+j;
				msg+=sum+" ";
				i=j;
				j=sum;
				steps--;
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