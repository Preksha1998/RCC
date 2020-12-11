class exe6{
	public static void main(String args[]){
		//int a,d=5;
		//int b[]={1,2,3,4,5};
		String ptr=null;
		try{
			if(ptr.equals("hetvee")){
				System.out.println("null pointer");
			}
			else{
				System.out.println("xyz");
			}
			//a=45/d;
			throw new ClassNotFoundException();
			//System.out.println("This Will Not Be Printed");
			//System.out.println("b[6]="+b[6]);
		}
		catch(NullPointerException e){
			System.out.println("Null Pointer");
		}
		catch(ArithmeticException e){
			System.out.println("Divide By Zero");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Array Index Out Of Bound");
		}
		catch(ClassNotFoundException e){
			System.out.println("Class Not Found Exception");
		}
		System.out.println("after catch statement");
	}
}