class Assertion1 {
	public static void main(String args[]) throws java.io.IOException
	{	
		int value=18;
		
		assert value>=20 : "Eligible";
		System.out.println("Value:" + value);
	}
}