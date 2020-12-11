
import java.util.*;
import java.net.*;

public class exe6Server{
	public static void main(String args[]){
		int port1=81,port2=1028;
		
		try{
			InetAddress iadd=InetAddress.getByName("localhost");
			Scanner sc=new Scanner(System.in);
			byte buf[]=new byte[30];
			DatagramSocket ds1=new DatagramSocket(port1);
			DatagramPacket dp1=new DatagramPacket(buf,buf.length);
			ds1.receive(dp1);
			String msg=new String(buf);
			System.out.println("Message From Client::"+msg.trim());
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
			
			DatagramPacket dp2=new DatagramPacket(msg.getBytes(),msg.length(),iadd,port2);
			ds1=new DatagramSocket();
			ds1.send(dp2);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
