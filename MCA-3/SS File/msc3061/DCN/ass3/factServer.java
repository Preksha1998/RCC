import java.io.*;
import java.util.*;
import java.net.*;
public class factServer{
	public static void main(String args[]) throws IOException{
		Scanner scn=new Scanner(System.in);
		ServerSocket ss=new ServerSocket(5056);
		Socket s;
		
		while(true){
				s=null;
				try{
				s=ss.accept();
				DataInputStream dis=new DataInputStream(s.getInputStream());
				DataOutputStream dos=new DataOutputStream(s.getOutputStream());	
					System.out.println("ASSIGNING NEW THREAD::");
					Thread t=new clientHandler(s,dis,dos);
					t.start();
				}
				catch(Exception e){
					s.close();
				}
		}
		
	}

}
class clientHandler extends Thread{
	final Socket s;
	final DataInputStream dis;
	final DataOutputStream dos;
	public clientHandler(Socket s,DataInputStream dis,DataOutputStream dos){
		this.s=s;
		this.dis=dis;
		this.dos=dos;
	}
	public void run(){
	//System.out.println("hello");
	
	while(true){
		try{
		dos.writeUTF("ENTER A CHOICE(EVEN-ODD/FACTORIAL)1 FOR EVEN-ODD 2 FOR FACTORIAL 3 FOR EXIT");
		System.out.println("statement written");
		int received=dis.readInt();
		String toreturn="";
			
				
				System.out.println("ENTERED CHOICE IS::"+received);
					if(received==3){
						System.out.println("CONNECTION CLOSED::"+this.s);
						this.s.close();
						System.out.println("CONNECTION CLOSED");
						break;
					}
					if(received==1 || received==2){
						int no;
						String toretuurn;
						dos.writeUTF("ENTER THE NUMBER::");
						no=dis.readInt();
						if(received==1){
							if(no%2==0)
								toreturn="even number";
							else
								toreturn="odd number";

							dos.writeUTF(toreturn);
						}
						else if(received==2){
							int fact=1;
							while(no>0){
								fact=fact*no;
								no--;
							}
							toreturn="factorial::"+fact;
							dos.writeUTF(toreturn);
						}
						else{
							dos.writeUTF("invalid");
						}
					
					}
					
		}
		catch(Exception e){}
	}
	
	}
}