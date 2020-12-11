class SSNTAB{
	String symbolName;
	
	void insert(String str){
		symbolName = str;
	}
	
	int isSymbol(String str, SSNTAB []st){
		for(int i=0; st[i].symbolName!=null; i++){
			if(st[i].symbolName.equalsIgnoreCase(str)){
				return i;
			}
		}
		return -1;
	}
}