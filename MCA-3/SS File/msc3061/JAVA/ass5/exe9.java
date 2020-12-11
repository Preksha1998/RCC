class exe9{
	public static void main(String args[]){
		a();
	}
	public static void a(){
		b();
	}
	public static void b(){
		exe9 a=new exe9();
		c();
	}
	public static void c(){
		try{
			throw new ClassNotFoundException("ERROR");
		}
		catch(ClassNotFoundException e){
			System.out.println("c::"+e);
		}
	}
}