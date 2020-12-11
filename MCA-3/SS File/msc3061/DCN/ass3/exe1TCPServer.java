import java.util.*;
import java.io.*;
import java.net.*;
import java.text.*;
public class exe1TCPServer{
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
				dos.writeUTF("WHAT DO YOU WANT[ARMSTRONG/PALINGDROME]ENTER 1 FOR ARMSTRONG,2 FOR PALINGDROME,EXIT FOR TERMINATE");
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
							int rev=0,sum=0,num1,cnt=0;
							
							num1=num;
							while(num>0){
								cnt++;
								num=num/10;
							}
							num=num1;
							while(num>0){
								sum=num%10;
								rev=(rev)+pow(sum,cnt);
								num=num/10;

							}
							if(rev==num1){
								toreturn="Armstrong";
							}
							else{
								toreturn="Not Armstrong";
							}
							dos.writeUTF(toreturn);
							break;
						case 2:
							dos.writeUTF("ENTER NUMBER FOR PALINGDROME::");
							m=dis.readUTF();
							int n=Integer.parseInt(m);
							int r=0,flag=0;
							int n1=n;
							while(n>0){
								r=(r*10)+(n%10);
								n=n/10;
							}
							if(n1==r){
							toreturn="pellingdrome";
							}
							else{
							toreturn="not pellingdrome";
							}
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

		
	

	
	
		
		
	
