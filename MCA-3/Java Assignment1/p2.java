public class p2{
	public static void main(String args[]){
		double first_no = Double.parseDouble(args[0]);
		double second_no = Double.parseDouble(args[1]);

		double mul = first_no * second_no;

		System.out.println("Product = "+ mul);
	}
}

//op:

//D:\MCA-III\Java Assignment1>java p2.java 4 5
//Product = 20.0