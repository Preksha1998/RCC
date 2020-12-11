import java.util.*;
import java.net.*;

public class ex1server{
	public static void main(String afdfghh[]){
		try{
		InetAddress ia=InetAddress.getByName("localhost");
		byte buff[]=new byte[50];
		DatagramPacket dp1=new DatagramPacket(buff,buff.length);
		DatagramSocket ds=new  DatagramSocket(1100);
		ds.receive(dp1);
		String msg;
		msg=new String(buff);
		System.out.println("Recive :"+msg);
		
		DatagramPacket dp2=new DatagramPacket(msg.getBytes(),msg.length(),ia,11);
		DatagramSocket ds2=new DatagramSocket();
		ds2.send(dp2);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	
}