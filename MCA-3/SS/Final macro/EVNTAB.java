class EVNTAB{
	String ev;
	static int count = 0;
	
	void insert(String str){
		ev = str;
		count++;
	}
	
	int isEV(String str, EVNTAB []et){
		for(int i=0; et[i].ev!=null; i++){
			if(et[i].ev.equalsIgnoreCase(str)){
				return i;
			}
		}
		return -1;
	}
}