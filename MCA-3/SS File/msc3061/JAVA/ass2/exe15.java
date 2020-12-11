class fact{
	int factorial(int num){
		int f=1;
		while(num>0){
			f=f*num;
			num--;
		}
		return f;
	}

}
class exe15{
	public static void main(String args[]){
	fact f1=new fact();
	int ans=f1.factorial(5);
	System.out.println("The Factorial Is::"+ans);
	}

}