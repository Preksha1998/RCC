import java.util.*;
import java.io.*;
import java.net.*;
public class exe5ass1TCPServer{
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
			int rev=0,sum=0,num1,cnt=0;
			int num=Integer.parseInt(msg.trim());
			num1=num;
			while(num>0){
				cnt++;
				num=num/10;
			}
			num=num1;
			while(num>0){
				sum=num%10;
				rev=(rev)+pow(sum,cnt);
				num=num/10;

			}
		if(rev==num1){
			msg="Armstrong";
		}
		else{
			msg="Not Armstrong";
		}
			
			OutputStream os=sc.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(msg);

			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	static int pow(int m,int n){
		int ans=1;
		while(n>0){
			ans=ans*m;
			n--;
		}
		return ans;
	}
}