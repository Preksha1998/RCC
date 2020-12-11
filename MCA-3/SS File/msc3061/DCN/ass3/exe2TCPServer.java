import java.util.*;
import java.io.*;
import java.net.*;
import java.text.*;
public class exe2TCPServer{
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
				dos.writeUTF("WHAT DO YOU WANT[SQUARE/CUBE]ENTER 1 FOR SQUARE,2 FOR CUBE,EXIT FOR TERMINATE");
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
					int num;
					String m;
					switch(choice){
						case 1:
							//int num=dis.readUTF();
							dos.writeUTF("ENTER THE NUMBER::");
							m=dis.readUTF();
							num=Integer.parseInt(m);
							int ans=num*num;
							toreturn=Integer.toString(ans);
							dos.writeUTF(toreturn);
							break;
						case 2:
							dos.writeUTF("ENTER THE NUMBER::");
							m=dis.readUTF();
							int n=Integer.parseInt(m);
							int ans1=n*n*n;
							toreturn=Integer.toString(ans1);
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
	static int pow(int m,int n){
		int ans=1;
		while(n>0){
			ans=ans*m;
			n--;
		}
		return ans;
	}
}

		
	

	
	
		
		
	
