import java.util.*;
import java.io.*;
import java.net.*;
import java.text.*;
public class exe3TCPServer{
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
		String toreturn="";
		
		while(true){
			try{
				dos.writeUTF("WHAT DO YOU WANT[EVEN-ODD/PRIME]ENTER 1 FOR EVEN-ODD,2 FOR PRIME,EXIT FOR TERMINATE");
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
					String m="";
					
					
							//int num=dis.readUTF();
						if(choice==1){
							dos.writeUTF("ENTER THE NUMBER::");
							m=dis.readUTF();
							num=Integer.parseInt(m);
							if(num%2==0)
								toreturn="even number";
							else
								toreturn="odd number";

							dos.writeUTF(toreturn);
						}
						else if(choice==2){
					
							dos.writeUTF("ENTER THE NUMBER::");
							int i=0,flag=0;
							m=dis.readUTF();
							int n=Integer.parseInt(m);
							for(i=2;i<=(n/2);i++){
								if(n%i==0){
									toreturn="Not Prime";
									flag=1;
									break;
								}
							}
							
							if(flag==0){
								toreturn="Number Is Prime";

							}
							dos.writeUTF(toreturn);
						}
						else{
							System.out.println("invalid");
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

		
	

	
	
		
		
	
