class scope{
	public static void main(String[] args){
		int x = 10;
		if(x == 10){
			//start new scope
			int y = 20;//y's scope upto if
			// we can access x and y both here because x is global and y is local var 
			System.out.println("X and Y : " + x + " : " + y);

			x = y * 2;

			System.out.println("Now X is " + x);
		}
		//here y is not accessible & x is accessible
	}
}