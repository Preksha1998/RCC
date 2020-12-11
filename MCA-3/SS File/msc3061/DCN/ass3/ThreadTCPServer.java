import java.util.*;
import java.io.*;
import java.net.*;
import java.text.*;
public class ThreadTCPServer{
	public static void main(String args[]) throws IOException{
		
			ServerSocket ss=new ServerSocket(81);
			while(true)
			{
			
			Socket s=null;
			try{
			s=ss.accept();
			System.out.println("A NEW CLIENT IS CONNECTED");
			
			
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			System.out.println("ASSIGNING A NEW THREAD");
			Thread t=new ClientHandler(s,dis,dos);
			t.start();
			}
			catch(IOException e){
				s.close();
					e.printStackTrace();
			}
		}
	}
}	
	
class ClientHandler extends Thread{
	
	final Socket s;
	DateFormat fordate=new SimpleDateFormat("yyyy/MM/dd");
	DateFormat fortime=new SimpleDateFormat("hh:mm:ss");
	final DataInputStream dis;
	final DataOutputStream dos;
	
	public ClientHandler(Socket s,DataInputStream dis,DataOutputStream dos){
		this.s=s;
		this.dis=dis;
		this.dos=dos;
	}
	//@Override
	public void run()
	{
		String received;
		String toreturn;
		
		while(true){
			try{
				dos.writeUTF("WHAT DO YOU WANT[DATE/TIME]ENTER 1 FOR DATE,2 FOR TIME,EXIT FOR TERMINATE");
				received=dis.readUTF();
				if(received.equalsIgnoreCase("EXIT")){
					System.out.println("CLIENT"+this.s+" ");
					System.out.println("CLOSING THE CONNECTION");
					this.s.close();
					System.out.println("CONNECTION CLOSED");
					break;
				}
				System.out.println("MESSAGE RECIEVED"+received);
				if(received.trim().equals("1") || received.trim().equals("2")){
					int choice=Integer.parseInt(received);
					Date date=new Date();
					switch(choice){
						case 1:
							toreturn=fordate.format(date);
							dos.writeUTF(toreturn);
							break;
						case 2:
							toreturn=fortime.format(date);
							dos.writeUTF(toreturn);
							break;
						default:
							dos.writeUTF("INVALID");
							break;
					}
				}
				else{
					dos.writeUTF("INVALID INPUT");
				}
			
			}
			
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
			try{
				this.dis.close();
				this.dos.close();
			}
			catch(IOException e){
					e.printStackTrace();
			}
		
	}
}

		
	

	
	
		
		
	
