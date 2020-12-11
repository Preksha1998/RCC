import java.util.*;
import java.io.*;
import java.net.*;
public class PaliStrUDPClient{
	public static void main(String args[]){
		int port1=81,port2=1024;
		try{
			Scanner scn=new Scanner(System.in);
			InetAddress iadd=InetAddress.getByName("localhost");
			String msg="";
			System.out.println("ENTER THE STRING::");
			msg=scn.nextLine();
			DatagramPacket dp1=new DatagramPacket(msg.getBytes(),msg.length(),iadd,port1);
			DatagramSocket ds1=new DatagramSocket();
			ds1.send(dp1);
			
			byte b[]=new byte[20];
			DatagramPacket dp2=new DatagramPacket(b,b.length);
			DatagramSocket ds2=new DatagramSocket(port2);
			ds2.receive(dp2);
			 msg=new String(b);
			System.out.println("ANS IS::"+msg);
			
		}
		catch(Exception e){}
	}
}