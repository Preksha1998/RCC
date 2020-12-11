abstract class bike{
	String model;
	double speed;
	bike(String m,double s){
		model=m;
		speed=s;
	}
	abstract void display();
}
class suzuki extends bike{
	suzuki(String m,double s){
		super(m,s);
	}
	void display(){
		System.out.println("THE BIKE MODEL IS::"+model);
		System.out.println("THE SPEED IS::"+speed+" kmph");
	}
}
class hero extends bike{
	hero(String m,double s){
		super(m,s);
	}
	void display(){
		System.out.println("THE BIKE MODEL IS::"+model);
		System.out.println("THE SPEED IS::"+speed+" kmph");
	}
}
class exe4{
	public static void main(String args[]){
		suzuki s=new suzuki("Dream Yuga",150);
		s.display();
		hero h=new hero("Dream Livo",300);
		h.display();
	}
}