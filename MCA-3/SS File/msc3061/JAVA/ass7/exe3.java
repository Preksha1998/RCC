import java.io.*;
class exe3{
public static void main(String args[]) throws IOException{
		BufferedWriter b1=new BufferedWriter(new FileWriter("test1.txt"));
		b1.write("K.S.SCHOOL OF BUSINESS MANAGEMENT");
		System.out.println("Write Successfully");
		b1.close();
	}
}