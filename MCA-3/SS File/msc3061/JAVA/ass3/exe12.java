class vehicle{
	void show(){
		System.out.println("IT'S A PARENT CLASS::VEHICLE");
	}
}	
class fourwheeler extends vehicle{
	void show(){
		System.out.println("IT'S A CHILD CLASS FOURWHEELER WHICH DERIVED FROM PARENT CLASS VEHICLE");
	}
}
class car extends fourwheeler{
	void show(){
		System.out.println("IT'S A CHILD CLASS CAR WHICH DERIVED FROM PARENT CLASS FOURWHEELER");
	}
}
class exe12{
	public static void main(String args[]){
		vehicle v=new vehicle();
		fourwheeler f=new fourwheeler();
		car c=new car();
		v.show();
		f.show();
		c.show();
	}
}