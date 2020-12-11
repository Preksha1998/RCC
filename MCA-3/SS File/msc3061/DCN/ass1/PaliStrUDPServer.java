import java.util.*;
import java.io.*;
import java.net.*;
public class PaliStrUDPServer{
	public static void main(String args[]){
		int port1=81,port2=1024;
		try{
			InetAddress iadd=InetAddress.getByName("localhost");
			Scanner scn=new Scanner(System.in);
			String msg="";
			byte b[]=new byte[20];
			DatagramPacket dp1=new DatagramPacket(b,b.length);
			DatagramSocket ds1=new DatagramSocket(port1);
			ds1.receive(dp1);
			
			msg=new String(b);
			char arr[]=msg.toCharArray();
			String str;
			int i;
			for(i=arr.length();i>0;i--){
				str[i]+=arr[i];
			}
			if(msg.equals(str)){
				msg="pallingdrome";
			}
			else{
				msg="not pallingdrome";
			}
			
			DatagramPacket dp2=new DatagramPacket(msg.getBytes(),msg.length(),iadd,port2);
			DatagramSocket ds2=new DatagramSocket();
			ds2.send(dp2);
			
			
		}
		catch(Exception e){}
	}
}