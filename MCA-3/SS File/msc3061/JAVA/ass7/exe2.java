import java.io.*;
class exe2{
public static void main(String args[]) throws IOException{
		DataOutputStream d1=new DataOutputStream(new FileOutputStream("test.txt"));
		d1.writeChar('A');
		d1.writeBoolean(true);
		d1.writeByte(1);
		d1.writeInt(10);
		d1.writeShort(100);
		d1.writeLong(1000);
		System.out.println("Write Successfully");
		d1.close();
	}
}