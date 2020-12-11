class fact{
	int factorial(int n){
		if(n==1){
		return 1;
		}
		else{
		return (n*factorial(n-1));
		}
	}
}
class exe14{
	public static void main(String args[]){
	fact f=new fact();
	System.out.println("The Factorial Is::"+f.factorial(5));
	}

}