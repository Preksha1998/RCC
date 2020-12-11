class shape{
	int h,width,breadth;
	shape(int h,int width){
		this.h=h;
		this.width=width;
	
	}
	shape(int h,int width,int breadth){
		this.h=h;
		this.width=width;
		this.breadth=breadth;
	}
	void area(){
		int ans,ans1;
		ans=h*width;
		ans1=h*width*breadth;
		System.out.println("The Area Of Two Parameterized Constructer Is::"+ans);
		System.out.println("The Area Of Three Parameterized Constructer Is::"+ans1);
	}
}
class exe2{
	public static void main(String args[]){
	shape s1=new shape(2,2,2);
	s1.area();
	
	}

}