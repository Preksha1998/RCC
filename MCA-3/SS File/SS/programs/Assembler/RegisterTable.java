import java.io.*;
class RegisterTable{
	int index;
	String rName;
	String rAddress;
	static int cnt = 0;
	
	public RegisterTable(int index , String rName , String rAddress){
		this.index = index;
		this.rName = rName;
		this.rAddress = rAddress;
		
		cnt++;
	}
	
	public static boolean isExist (RegisterTable [] rTab , String rgs){
		for(RegisterTable obj : rTab){
			if(obj != null && obj.rName.equals(rgs)){
				return true;
			}
		}
		return false;
	}
	
	public static int getIndex(RegisterTable [] rTab , String rgs){
		for(RegisterTable obj : rTab){
			if(obj != null && obj.rName.equals(rgs)){
				return obj.index;
			}
		}
		return -1;
	}
	
	public static String getAddress(RegisterTable [] rTab ,int idx){
		for(RegisterTable obj : rTab){
			if(obj.index == idx){
				return obj.rAddress;
			}
		}
		return "Error";
	}
	
	public String toString(){
		return ( index + "\t" + rName + "\t" + rAddress);
	}
	
	public static void showRegister(RegisterTable [] rTab) throws IOException{
		BufferedWriter bw = new BufferedWriter( new FileWriter("Register.txt"));
		
		System.out.println("\nRegister table");
		
		for(RegisterTable obj : rTab){
			bw.write(obj.index + "\t" + obj.rName + "\t" + obj.rAddress);
			bw.newLine();
			
			System.out.println(obj);
		}
		bw.close();
	}
}