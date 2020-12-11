class MNT{
	String macroName;
	int noPP;
	int noKP;
	int noEV;
	int MDTP;
	int KPDTP;
	int SSTP;
	static int count = 0;
	
	MNT(){
		macroName = null;
		noPP = -1;
		noKP = -1;
		noEV = -1;
		MDTP = -1;
		KPDTP = -1;
		SSTP = -1;
		count++;
	}
	
	void display(){
		System.out.println(macroName + "     \t" + noPP + "\t" + noKP + "\t" + noEV + "\t" + MDTP + "\t" + KPDTP + "\t" + SSTP);
	}
	
	int isMNT(String str, MNT []mt){
		for(int i=0; i<count-1; i++){
			if(mt[i].macroName.equalsIgnoreCase(str)){
				return i;
			}
		}
		return -1;
	}
}