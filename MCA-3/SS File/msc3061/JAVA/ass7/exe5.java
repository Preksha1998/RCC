import java.io.*;
class exe5{
public static void main(String args[]) throws IOException{
		
		
		FileInputStream f1=new FileInputStream("test1.txt");
		int i;
		String s=" ";
		while((i=f1.read())!=-1){
		s=s+(char)(i);
		}
		StringReader s1=new StringReader(s);
		while((i=s1.read())!=-1){
		System.out.print((char)(i));
		}

		
		
		
		
	}
}