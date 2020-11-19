//import java.util.Scanner;
class galTolit{
	public static void main(String[] args){
		double gallons;
		double liters;
		
		gallons = 10;
		//Scanner obj = new Scanner(System.in);
		//System.out.print("Enter value for Gallons : ");
		//gallons = obj.nextDouble();
		
		liters = gallons * 3.7854; // convert gallons to liters
		System.out.println(gallons +" Gallons is" + liters + " liters..");
		
	}
}