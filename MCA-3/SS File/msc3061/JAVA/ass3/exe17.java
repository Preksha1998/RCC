interface demo{
	int factorial(int num);	
}
class fact implements demo{
	public int factorial(int num){
		int fac=1;
		while(num>0){
			fac=fac*num;
			num--;
		}
	return fac;
	}	

}
class exe17{
	public static void main(String args[]){
		fact f=new fact();
		System.out.println("FINDING FACTORIAL THROUGH INTERFACE::"+f.factorial(5));
	}
}