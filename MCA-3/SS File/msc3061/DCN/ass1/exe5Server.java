import java.util.*;
import java.net.*;

public class exe5Server{
	public static void main(String args[]){
		int port1=81,port2=1028;
		
		try{
			InetAddress iadd=InetAddress.getByName("localhost");
			Scanner sc=new Scanner(System.in);
			byte buf[]=new byte[20];
			DatagramSocket ds1=new DatagramSocket(port1);
			DatagramPacket dp1=new DatagramPacket(buf,buf.length);
			ds1.receive(dp1);
			String msg=new String(buf);
			System.out.println("Message From Client::"+msg.trim());
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
			DatagramPacket dp2=new DatagramPacket(msg.getBytes(),msg.length(),iadd,port2);
			ds1=new DatagramSocket();
			ds1.send(dp2);
		}
		catch(Exception ex){
			ex.printStackTrace();
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