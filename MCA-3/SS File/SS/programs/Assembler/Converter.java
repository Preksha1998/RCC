class Converter{
	static int parseInt(String str){
		int iVal;
		try{
			iVal = Integer.parseInt(str);
		}
		catch(NumberFormatException e){
			iVal = 0;
		}
		return iVal;
	}
	
	static boolean isImperative(MnemonicTable [] mTab ,String token){
		String mClass = MnemonicTable.getClass(mTab,token);
		if (mClass.equals("IS"))
			return true;
		else
			return false;
	}
	
	static boolean isAssemblyDirective(MnemonicTable [] mTab ,String token){
		String mClass = MnemonicTable.getClass(mTab,token);
		if ( mClass.equals("AD"))
			return true;
		else
			return false;
	}
	
	static boolean isDeclarative(MnemonicTable [] mTab ,String token){
		String mClass = MnemonicTable.getClass(mTab,token);
		if ( mClass.equals("DL"))
			return true;
		else
			return false;
	}
	
	static boolean isBranchCondition(String str){
		if(str.equals("LE") || str.equals("LT") || str.equals("EQ") || str.equals("GT") || str.equals("GE") || str.equals("ANY"))
			return true;
		else
			return false;
	}
	
	static int getBranchCode(String code){
		String [] bCode = {"LE","LT","EQ","GT","ANY","GE"};
		
		for(int i=0 ; i<bCode.length ;i++){
			if(bCode[i].equals(code))
				return i;
		}
		return -1;
	}
}