/*33LambdaArgumentDemo*/

interface StringFunc{
	String func(String str);
}

class LambdaArgumentDemo{
	static String changeStr(StringFunc sf, String s){
		return sf.func(s);
	}

	public static void main(String args[])
	{
		String inStr = "Lambda Expressions Expand java";
		String outStr;
		System.out.println("Here is input String :" + inStr);
	}
}


/*D:\MCA-III\java>java LambdaArgumentDemo
Here is input String :Lambda Expressions Expand java*/
