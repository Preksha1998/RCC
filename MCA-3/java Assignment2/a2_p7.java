/*

7.Write a program to get java version, runtime version ,java vendor name , java vendor url

*/

class a2_p7
{
	public static void main(String[] args)
	{
		System.out.println("Java Version: " + System.getProperty("java.version"));
		System.out.println("Vendor Name: " + System.getProperty("java.vendor"));
		System.out.println("Vendor URL: " + System.getProperty("java.vendor.url"));
	}
}

/*
Output:-

Java Version: 14.0.2
Vendor Name: Oracle Corporation
Vendor URL: https://java.oracle.com/

*/