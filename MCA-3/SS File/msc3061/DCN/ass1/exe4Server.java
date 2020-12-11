import java.util.*;
import java.net.*;

public class exe4Server{
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
			String str=msg.trim();
			char arr[]=str.toCharArray();
			String str1="";
			System.out.println("The Value Is::");
			for(int i=arr.length-1;i>=0;i--){
			System.out.println(arr[i]+" ");
			str1+=arr[i];
			}
			if(str.equals(str1)){
				msg="pellingdrome";
			}
			else{
				msg="not pellingdrome";
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


