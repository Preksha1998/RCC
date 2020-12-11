class exe8{

	public static void main(String args[]){
		int rev=0,num=153,sum=0;
		while(num>0){
			rev=(rev)+(num%10)*(num%10)*(num%10);
			num=num/10;

		}
		System.out.println("The Armstrong Number Is:"+rev);

		
	}


}