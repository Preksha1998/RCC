class func{
	func(){
		System.out.println("Parent Class");
	}
	void display(){
		System.out.println("Parent Class");
	}

}
class f1 extends func{
	f1(){
		System.out.println("Child Class");
	}
	void display(){
		System.out.println("Child Class");
	}

}
class pr1{
	public static void main(String args[]){
		f1 f=new f1();
		f.display();
		func f2=new func();
		f2.display();

	}

}