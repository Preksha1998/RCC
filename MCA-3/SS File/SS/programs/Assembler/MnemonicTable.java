class MnemonicTable{
	int index;
	String mnemonic;
	String operationCode;
	String mClass;
	int mLength;
	static int N;
	
	public MnemonicTable(int index,String mnemonic,String operationCode,String mClass,int mLength){
		this.index = index;
		this.mnemonic = mnemonic;
		this.operationCode = operationCode;
		this.mClass = mClass;
		this.mLength = mLength;
		N++;
	}
	
	public static String getCode(MnemonicTable []mTab , String token){
		String code = "";
		
		for(MnemonicTable obj : mTab){
			if(obj.mnemonic.equals(token)){
				code = "(" + obj.mClass + "," + obj.index + ")";
				break;
			}
		}
		return code.toString();
	}
	
	public static boolean isExist(MnemonicTable [] mTab ,String token){
		for(MnemonicTable obj : mTab){
			if( obj != null && obj.mnemonic.equals(token))
				return true;
		}
		return false;
	}
	
	public static String getClass (MnemonicTable [] mTab ,String token){
		for(MnemonicTable obj : mTab){
			if(obj.mnemonic.equals(token))
				return obj.mClass;
		}
		return "Error";
	}
	
	public static int getIndex(MnemonicTable [] mTab ,String token){
		for(MnemonicTable obj : mTab){
			if(obj.mnemonic.equals(token))
				return obj.index;
		}
		return -1;
	}
	
	public static String getAddress(MnemonicTable [] mTab ,int idx){
		for(MnemonicTable obj : mTab){
			if(obj.index == idx)
				return obj.operationCode;
		}
		return "Error";
	}
	
	// override toString method
	public String toString(){
		return ( index + "\t" + mnemonic + "\t" + operationCode + "\t" + mClass + "\t" + mLength);
	}
	
	public static void showMnemonic(MnemonicTable [] mTab){
		System.out.println("\nMnemonic table");
		for(MnemonicTable obj : mTab){
			System.out.println(obj);
		}
	}
}