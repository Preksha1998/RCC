import java.util.*;
import java.io.*;
import java.net.*;
public class exe3TCPClient{
	public static void main(String args[]) throws IOException{
		try{
			InetAddress ip=InetAddress.getByName("localhost");
			Socket sc=new Socket(ip,81);
			Scanner s=new Scanner(System.in);
			String msg="";
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
				//System.out.println(dis.readUTF());
				// String ch=s.nextLine();
				// dos.writeUTF(ch);
				String received=dis.readUTF();
				System.out.println(received);
				//System.out.println("ENTER THE NUMBER::");
				String num=s.nextLine();
				dos.writeUTF(num);
				String ans=dis.readUTF();
				System.out.println("ANS IS::"+ans);
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