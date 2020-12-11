class demo{
	int a1,a2,a3;
	demo(){
		System.out.println("Default Constructer Is Called");
	}
	demo(int a){
		a1=a;
		System.out.println("The Constructor with 1 parameter is called"+a1);
	}
	demo(int a,int b){
		a2=a;
		a3=b;
		System.out.println("The Constructr with 2 parameters is called::"+a2+a3);
	}

}
class exe10{
	public static void main(String args[]){
	demo d2=new demo();
	demo d=new demo(1);
	demo d1=new demo(1,2);
	}

}