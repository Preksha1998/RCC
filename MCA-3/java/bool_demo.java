class bool_demo{
	public static void main(String[] args){
		boolean b;
		b = false;
		System.out.println("\nB = " + b);

		b = true;
		System.out.println("\nB = " + b);

		//a boolean val can becontrol using if statement
		if(b)	System.out.println("\nThis is executed..");		
		
		b = false;
		if(!b)	System.out.println("\nThis is not executed..");

		//outcome of the relational operator is boolean:

		System.out.println("\n10 > 9 is " + (10 > 9));
	}
}