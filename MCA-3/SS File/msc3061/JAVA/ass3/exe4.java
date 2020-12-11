class Mychain{
	int i,j;
	Mychain(){
		System.out.println("DEFAULT CONSTRUCTER CALLED");
	}
	Mychain(int i,int j){
		this.i=i;
		this.j=j;
		System.out.println("PARAMETERIZED CONSTRUCTOR CALLED::"+" "+i+" "+j);
	}
	Mychain(int i){
		this.i=i;
		System.out.println("ONE PARAMETERIZED CONSTRUCTOR CALLED::"+" "+i);
	}
}
class exe4{
	public static void main(String args[]){
		Mychain m=new Mychain();
		Mychain m1=new Mychain(10,20);
		Mychain m2=new Mychain(5);
	}
}