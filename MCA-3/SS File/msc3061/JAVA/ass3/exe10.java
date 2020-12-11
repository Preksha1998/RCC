class demo{
	int a,b;
	demo(){
		System.out.println("DEFAULT CONSTRUCTER CALLED");
	}
	demo(int a){
		this.a=a;
		System.out.println("DEMO OF THIS KEYWORD WITH ONE PARAMETERIZED CONSTRUCTER::"+a);
	}
	demo(int a,int b){
		this.a=a;
		this.b=b;
		System.out.println("DEMO OF THIS KEYWORD WITH TWO PARAMETERIZED CONSTRUCTER::"+a+" "+b);
	}
}
class exe10{
	public static void main(String args[]){
		demo d=new demo();
		demo d1=new demo(5);
		demo d2=new demo(10,20);
	}

}