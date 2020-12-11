class Register{
	int index;
	String rName;
	String rAddress;
	
	public Register(int index , String rName ,String rAddress){
		this.index = index;
		this.rName = rName;
		this.rAddress = rAddress;
	}
	
	public static boolean isExist(Register rTab[] , String token){
		for (Register obj : rTab){
			if( obj!=null && obj.rName.equals(token)){
				return true;
			}
		}
		return false;
	}

	public static int getIndex(Register rTab[] , String token){
		for (Register obj : rTab){
			if(obj.rName.equals(token)){
				return obj.index;
			}
		}
		return -1;
	}
	
	public static String getAddress(Register rTab[] , int idx){
		for (Register obj : rTab){
			if(obj.index == idx){
				return obj.rAddress;
			}
		}
		return "Error";
	}
	
	public String toString()
	{
		return (index + "\t" + rName + "\t" +rAddress);
	}
	
	public static void showRegister(Register rTab[]){
		System.out.println("\nRegister table");
		for (Register obj : rTab){
			System.out.println(obj);
		}
	}
}