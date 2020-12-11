import java.util.*;
import java.io.*;
import java.net.*;
public class ThreadTCPClient{
	public static void main(String args[]) throws IOException{
		try{
			InetAddress ip=InetAddress.getByName("localhost");
			Socket sc=new Socket(ip,81);
			Scanner s=new Scanner(System.in);
			System.out.println("ENTER A STRING::");
			String msg=s.nextLine();
			InputStream is=sc.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			OutputStream os=sc.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			while(true){
			System.out.println(dis.readUTF());
			String tosend=s.nextLine();
			dos.writeUTF(tosend);
				if(tosend.equalsIgnoreCase("EXIT")){
					System.out.println("CLOSING THE CONNECTION");
					sc.close();
					System.out.println("CONNECTION CLOSE");
					break;
				
				}
				String received=dis.readUTF();
				System.out.println(received);
			}
		s.close();
		dis.close();
		dos.close();
		}	
		
		
	
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}