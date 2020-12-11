class staticDemo{
	static int a=0,b=1,c=0;
	static void fiboseries(int n){
		//int i=1,j=0,sum=0;
		System.out.println("Fibonaki is::");
		while(n>0){
			System.out.println(c+"");
			c=a+b;
			b=a;
			a=c;
			n--;
		}
	}
}
class exe1{
	public static void main(String args[]){
		staticDemo s=new staticDemo();
		int n=7;
		s.fiboseries(n);
	}

}