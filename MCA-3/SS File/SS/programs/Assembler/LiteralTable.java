import java.io.*;
class LiteralTable{
	int index;
	String literal;
	int address;
	static int tLiteral;
	static int tUpdate;
	
	public LiteralTable(){
	}
	
	public LiteralTable(int index,String literal,int address){
		this.index = index;
		this.literal = literal;
		this.address = address;
	}
	
	public static void addLiteral(LiteralTable[] lTab , String ltr){
		lTab[tLiteral] = new LiteralTable();
		lTab[tLiteral].index = tLiteral;
		lTab[tLiteral].literal = ltr;
		
		tLiteral++;
	}
	
	public static int getAddress(LiteralTable [] lTab , int idx){
		for(LiteralTable obj : lTab){
			if(obj.index == idx)
				return obj.address;
		}
		return -1;
	}
	
	public static int getIndex(LiteralTable [] lTab , String ltr){
		for(LiteralTable obj : lTab){
			if(obj.literal.equals(ltr))
				return obj.index;
		}
		return -1;
	}
	
	public static int updateLiteral(LiteralTable [] lTab ,int endIdx , int lCounter){
		for(int i= tUpdate; i<endIdx ;i++){
			lTab[i].address = lCounter;
			lCounter+=2;
			tUpdate++;
		}
		return lCounter;
	}
	
	//Overload addLiteral
	public static void addLiteral(LiteralTable[] lTab ,int index, String ltr,int address){
		lTab[tLiteral] = new LiteralTable();
		lTab[tLiteral].index = index;
		lTab[tLiteral].literal = ltr;
		lTab[tLiteral].address = address;
		tLiteral++;
	}
	
	//Override toString
	public String toString(){
		return (index + "\t" + literal + "\t" + address);
	}
	
	public static void showLiteral(LiteralTable []lTab) throws IOException{
		BufferedWriter bw = new BufferedWriter ( new FileWriter ("Literal.txt"));
		
		System.out.println("\nLiteral table");
		for(LiteralTable obj : lTab){
			if(obj != null){
				bw.write(obj.index + "\t" + obj.literal + "\t" + obj.address);
				bw.newLine();
				System.out.println(obj);
			}
		}
		bw.close();
	}
}