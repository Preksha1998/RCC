class Error{
	static int cnt = 0;
	int lno;
	String msg;
	String token;
	boolean eFlag = true;
	
	public static void addError(Error [] err , int lno ,String msg , boolean eFlag){
		err[cnt] = new Error();
		err[cnt].lno = lno;
		err[cnt].msg = msg;
		err[cnt].token = "";
		err[cnt].eFlag = eFlag;
		cnt++;
	}
	
	// overload addError
	public static void addError(Error [] err , int lno ,String msg,String token , boolean eFlag){
		err[cnt] = new Error();
		err[cnt].lno = lno;
		err[cnt].msg = msg;
		err[cnt].token = token;
		err[cnt].eFlag = eFlag;
		cnt++;
	}
	
	public static int getTotalError(){
		return cnt;
	}
	
	// override toString
	
	public String toString(){
		return (lno + " \t" + msg + " \t" + token + "  " + eFlag);
	}
	
	public static void showError(Error []err){
		System.out.println("\nErrors");
		for(Error obj : err ){
			if(obj != null && obj.eFlag == true)
				System.out.println(obj);
		}
	}
	
}