import java.util.*;
import java.net.*;
public class ex1client{
	public static void main(String arg[]){
		try{
			InetAddress ia=InetAddress.getByName("localhost");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Number");
			String msg=sc.nextLine();
			DatagramPacket dp1=new DatagramPacket(msg.getBytes(),msg.length(),ia,1100);
			DatagramSocket ds=new DatagramSocket();
			ds.send(dp1);
			
			byte buff[]=new byte[50];
			DatagramPacket dp2=new DatagramPacket(buff,buff.length);
			DatagramSocket ds2=new DatagramSocket(11);
			ds2.receive(dp2);
			msg=new String(buff);
			System.out.println("get :"+msg);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}