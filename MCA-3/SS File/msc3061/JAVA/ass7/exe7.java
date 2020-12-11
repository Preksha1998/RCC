import java.io.*;
class exe7{
	public static void main(String args[]) throws IOException{
		int a;
		FileInputStream in;
		FileOutputStream out;
		in=new FileInputStream("test1.txt");
		out=new FileOutputStream("f5.txt");
		try{
			while((a=in.read())!=-1){
				out.write(a);
			}
		}
		catch(IOException e){}
		System.out.println("COPIED SUCCESSFULLY");
		
	}
}