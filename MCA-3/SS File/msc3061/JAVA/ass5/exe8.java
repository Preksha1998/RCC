class exe8{
	public static void main(String args[]){
		a();
	}
	public static void a(){
		try{
			b();
		}
		catch(ArithmeticException e){
				System.out.println("a::"+e);
			}
		
	}
	public static void b(){
		try{
			c();
		}
		catch(ArithmeticException e){
				System.out.println("b::"+e);
				throw e;
			}
		
	}
	public static void c(){
		try{
			d();
		}
		catch(ArithmeticException e){
				System.out.println("c::"+e);
				throw e;
			}
		
	}
	public static void d(){
		try{
		
		int ans=10/0;
		}
		catch(ArithmeticException e){
				System.out.println("class cast exception"+e);
				throw e;
			}
		
	}
	
}