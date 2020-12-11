import java.util.*;
import java.net.*;
public class UDPclient{
	public static void main(String args[]){
		int port1=81,port2=1028;
		try{
			InetAddress iadd=InetAddress.getByName("localhost");
			Scanner sc=new Scanner(System.in);
			System.out.println("ENTER A NUMBER::");
			String msg=sc.nextLine();
			DatagramPacket dp1=new DatagramPacket(msg.getBytes(),msg.length(),iadd,port1);
			DatagramSocket ds1=new DatagramSocket();
			ds1.send(dp1);

			byte buf[]=new byte[20];
			DatagramPacket dp2=new DatagramPacket(buf,buf.length);
			DatagramSocket ds2=new DatagramSocket(port2);
			ds2.receive(dp2);
			msg=new String(buf);
			System.out.println("Factorial is::"+msg.trim());
 
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}