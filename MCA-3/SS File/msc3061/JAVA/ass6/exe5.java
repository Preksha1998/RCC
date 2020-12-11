import java.util.*;
interface shape{
	void area();
}
class triangle implements shape{
	Scanner sc=new Scanner(System.in);
	double b,h;
	
	public void area(){
		System.out.println("ENTER BREADTH AND HEIGHT::");
		b=sc.nextDouble();
		h=sc.nextDouble();
		System.out.println("AREA OF TRIANGLE IS::"+(0.5*b*h));
	}	
}
class rectangle implements shape{
	Scanner sc=new Scanner(System.in);
	double b,l;
	
	public void area(){
		System.out.println("ENTER BREADTH AND LENGTH::");
		b=sc.nextDouble();
		l=sc.nextDouble();
		System.out.println("AREA OF RECTANGLE IS::"+(b*l));
	}	
}
class circle implements shape{
	Scanner sc=new Scanner(System.in);
	
	public void area(){
		double r;
		System.out.println("ENTER RADIUS::");
		r=sc.nextDouble();
		System.out.println("AREA OF CIRCLE IS::"+(3.14*r*r));
	}	
}
class exe5{
	public static void main(String args[]){
	triangle t=new triangle();
	rectangle r=new rectangle();
	circle c=new circle();
	t.area();
	r.area();
	c.area();

}
}