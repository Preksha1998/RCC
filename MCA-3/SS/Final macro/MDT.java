class MDT{
	String macroLine;
	static int count = 0;
	
	void insert(String str){
		macroLine = str;
		count++;
	}
	
	void display(){
		System.out.println(macroLine);
	}
}