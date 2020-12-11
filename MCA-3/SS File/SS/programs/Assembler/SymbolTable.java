import java.io.*;
class SymbolTable{
	int index;
	String sName;
	int sAddress;
	boolean defined;
	static int cnt = 0;
	
	public SymbolTable(){
		defined = false;
	}
	
	public SymbolTable(int index,String sName,int sAddress,boolean defined){
		this.index = index;
		this.sName = sName;
		this.sAddress = sAddress;
		this.defined = defined;
	}
	
	public static void addSymbol(SymbolTable[] sTab ,String sName ,int sAddress,boolean defined ) throws IOException{
	
		sTab[cnt] = new SymbolTable();
		sTab[cnt].index = cnt;
		sTab[cnt].sName = sName;
		sTab[cnt].sAddress = sAddress;
		sTab[cnt].defined = defined;
		cnt++;
	}
	
	public static void addSymbol(SymbolTable[] sTab,int index ,String sName ,int sAddress,boolean defined ) throws IOException{
	
		sTab[cnt] = new SymbolTable();
		sTab[cnt].index = index;
		sTab[cnt].sName = sName;
		sTab[cnt].sAddress = sAddress;
		sTab[cnt].defined = defined;
		cnt++;
	}
	
	public static boolean isExist(SymbolTable [] sTab ,String token){
		for(SymbolTable obj : sTab){
			if( obj!= null && obj.sName.equals(token))
				return true;
		}
		return false;
	}
	
	public static int getAddress(SymbolTable [] sTab ,String token){
		for(SymbolTable obj : sTab){
			if(obj.sName.equals(token))
				return obj.sAddress;
		}
		return -1;
	}
	
	public static int getAddress(SymbolTable [] sTab ,int idx){
		for(SymbolTable obj : sTab){
			if(obj.index == idx)
				return obj.sAddress;
		}
		return -1;
	}
	
	public static int getIndex(SymbolTable [] sTab ,String token){
		for(SymbolTable obj : sTab){
			if(obj.sName.equals(token))
				return obj.index;
		}
		return -1;
	}
	
	public static boolean isDefined(SymbolTable [] sTab ,String token){
		for(SymbolTable obj : sTab){
			if(obj != null && obj.sName.equals(token) && obj.defined == false)
				return true;
		}
		return false;
	}
	
	public static void updateSymbol(SymbolTable []sTab ,String token,int address){
		for(int i=0  ;i <cnt ;i++){
			if(sTab[i].sName.equals(token)){
				sTab[i].sAddress = address;
				sTab[i].defined = true;
			}
		}
	}
	
	public String toString(){
		return (index + "\t" + sName + "\t" + sAddress);
	}
	
	public static void showSymbol(SymbolTable []sTab) throws IOException{
	
		BufferedWriter bw = new BufferedWriter ( new FileWriter ("Symbol.txt"));
		
		System.out.println("\nSymbol table");
		
		for(SymbolTable  obj: sTab ){
			if(obj != null && obj.sAddress != 0 && obj.defined == true){
				bw.write(obj.index + "\t" + obj.sName + "\t" + obj.sAddress);
				bw.newLine();
				System.out.println(obj);
			}
		}
		bw.close();
	}
}