class abc{
	void show(){
		System.out.println("Call From Parent Class");
	}
}
class def extends abc{
	void show(){
		System.out.println("Call From Child Class");
	}
}
class exe11{
	public static void main(String args[]){
		abc a=new abc();
		a.show();
		def d=new def();
		d.show();
	}
}