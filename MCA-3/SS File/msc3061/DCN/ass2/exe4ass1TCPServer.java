import java.util.*;
import java.io.*;
import java.net.*;
public class exe4ass1TCPServer{
	public static void main(String args[]){
		try{
			String msg="";
			ServerSocket ss=new ServerSocket(81);
			Socket sc=ss.accept();
			Scanner s=new Scanner(System.in);
			InputStream is=sc.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			msg=(String)dis.readUTF();
			System.out.println("Message From Client is::"+msg.trim());
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
			
			OutputStream os=sc.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(msg);

			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}