abstract class figure{
	double dim1;
	double dim2;
	figure(double a,double b){
		dim1=a;
		dim2=b;
	}
	abstract void area();

}
class rectangle extends figure{
	rectangle(double a,double b){
		super(a,b);
	}
	void area(){
		System.out.println("AREA OF RECTANGLE IS::"+dim1*dim2);
	}
}
class triangle extends figure{
	triangle(double a,double b){
		super(a,b);
	}
	void area(){
		System.out.println("AREA OF TRIANGLE IS::"+(dim1*dim2)/2);
	}
}
class exe2{
	public static void main(String args[]){
		rectangle r=new rectangle(10,2);
		r.area();
		triangle t=new triangle(10,5);
		t.area();
	}
}