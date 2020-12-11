import java.util.*;
class exe7{
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
		catch(ArrayIndexOutOfBoundsException e){
				System.out.println("b::"+e);
			}
		
	}
	public static void c(){
		try{
			d();
		}
		catch(NumberFormatException e){
				System.out.println("c::"+e);
			}
		
	}
	public static void d(){
		try{
		int arr[]=new int[3];
		arr[4]=10;
		int ans=10/0;
		}
		catch(ClassCastException e){
				System.out.println("class cast exception"+e);
			}
		
	}
	
}