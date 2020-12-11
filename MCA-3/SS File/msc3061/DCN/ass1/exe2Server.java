import java.util.*;
import java.net.*;
public class exe2Server{
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
			msg="Number Is Prime";

		}
	
			
			DatagramPacket dp2=new DatagramPacket(msg.getBytes(),msg.length(),iadd,port2);
			ds1=new DatagramSocket();
			ds1.send(dp2);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}