class s1{
	void sum(int a,int b){
		int ans=a+b;
		System.out.println("The Addition of 2 nos is::"+ans);
	}
	void sum(double a,double b){
		double ans=a+b;
		System.out.println("The Addition of 2 nos is::"+ans);
	}

}
class exe12{
	public static void main(String args[]){
	s1 s=new s1();
	s.sum(10,20);
	s1 s2=new s1();
	s2.sum(10,20);
	
	}

}