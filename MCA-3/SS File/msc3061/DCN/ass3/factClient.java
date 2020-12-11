import java.io.*;
import java.util.*;
import java.net.*;
import java.text.*;
public class factClient{
	public static void main(String args[]) throws IOException{
		Scanner scn=new Scanner(System.in);
		InetAddress ip=InetAddress.getByName("localhost");
		Socket s=new Socket(ip,5056);
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		try{
			while(true){
				System.out.println(dis.readUTF());
				System.out.println("statement read");
				int choice=scn.nextInt();
				dos.writeInt(choice);
				if(choice==3){
						System.out.println("CONNECTION CLOSED::"+s);
						s.close();
						System.out.println("CONNECTION CLOSED");
						break;
				}
				if(choice==1 || choice==2){
					System.out.println(dis.readUTF());
					int num=scn.nextInt();
					dos.writeInt(num);
				}
			}
			System.out.println("ANSWER IS::"+dis.readUTF());
		}
		catch(Exception e){
		
		}
	}

}