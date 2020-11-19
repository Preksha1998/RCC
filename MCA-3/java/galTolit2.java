class galTolit2{
	public static void main(String[] args){
		double gallons,liters;
		int counter;
		
		counter = 0;
		for(gallons = 1; gallons <= 20; gallons++)//generate table upto 50
		{
			liters = gallons * 3.7854;
			System.out.println(gallons + "gallons is " + liters + "liters..");
			counter++;
			if(counter == 100)
			{
				System.out.println();
				counter = 0;
			}
		}
	}
}