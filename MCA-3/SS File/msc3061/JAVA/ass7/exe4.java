import java.io.*;
class exe4{
public static void main(String args[]) throws IOException{
		char arr[]={'H','E','T','U'};
		CharArrayReader c1=new CharArrayReader(arr);
		int i;
	
		while((i=c1.read())!=-1){
			System.out.println((char)(i));	
		}
		
		
		
	}
}