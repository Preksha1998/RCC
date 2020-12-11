interface Drawable{
	void area();
}
class rectangle implements Drawable{
	int l,b;
	rectangle(int l,int b){
		this.l=l;
		this.b=b;
	}
	public void area(){
		System.out.println("AREA OF RECTANGLE IS::"+(l*b));
	}
}
class circle implements Drawable{
	int r;
	circle(int r){
		this.r=r;

	}
	public void area(){
		System.out.println("AREA OF CIRCLE IS::"+(3.14*r*r));
	}
}
class exe2{
	public static void main(String args[]){
		rectangle r=new rectangle(10,2);
		r.area();
		circle c=new circle(10);
		c.area();
		
	}
}