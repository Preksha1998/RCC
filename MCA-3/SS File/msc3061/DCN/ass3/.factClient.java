import java.io.*;
import java.util.*;
import java.net.*;
public class factClient{
	public static void main(String args[]){
		Scanner scn=new Scanner(System.in);
		InetAddress ip=InetAddress.getByName("localhost");
		Socket s=new Socket(ip,5056);
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		try{
			while(true){
				System.out.println(dis.readUTF());
				int choice=scn.nextInt();
				dis.writeInt(choice);
			}
		}
		catch(Exception e){
		
		}
	}

}