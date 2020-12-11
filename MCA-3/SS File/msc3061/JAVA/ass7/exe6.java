import java.io.*;
class exe6{
public static void main(String args[]) throws IOException{
	File f1=new File("test2.txt");
	f1.createNewFile();
	System.out.println("GET FILE NAME::"+f1.getName());
	System.out.println("GET FILE PATH::"+f1.getPath());
	System.out.println("GET ABSOLUTE PATH::"+f1.getAbsolutePath());
	System.out.println("GET PARENT::"+f1.getParent());
	System.out.println("FILE EXISTS OR NOT::"+f1.exists());
	if(f1.exists()){
	System.out.println("CAN READ::"+f1.canRead());
	System.out.println("CAN WRITE::"+f1.canWrite());
	System.out.println("FILE LENGTH::"+f1.length());
	}
		
	}
}