import java.io.*;
class exe1{
public static void main(String args[]) throws IOException{
	File f1=new File("f1.txt");
	File f2=new File("f2.txt");
	File f3=new File("f3.txt");
	File f4=new File("f4.txt");
	FileOutputStream fos1=new FileOutputStream(f1);
	FileOutputStream fos2=new FileOutputStream(f2);
	FileOutputStream fos3=new FileOutputStream(f3);
	FileOutputStream fos4=new FileOutputStream(f4);
	int a[]=new int[]{65,66,67,68};
	for(int i=0;i<4;i++){
		fos1.write(a[i]);
		fos2.write(a[i]);
		fos3.write(a[i]);
		fos4.write(a[i]);
	}
	System.out.println("Write Successfully");
	fos1.close();
	fos2.close();
	fos3.close();
	fos4.close();
}
}