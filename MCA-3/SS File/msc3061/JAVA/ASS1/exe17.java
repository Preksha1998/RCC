class func{
	void armstrong(){
	int rev=0,num=153,sum=0,num1;
	num1=num;

		while(num>0){
			rev=(rev)+(num%10)*(num%10)*(num%10);
			num=num/10;

		}
		if(rev==num1){
			System.out.println("The Number Is Armstrong"+num);
		}
		else{
			System.out.println("The Number Is Not Armstrong"+num);
		}
		


	}

}
class exe17{
	public static void main(String args[]){
		int rev=0,num=157,sum=0,num1;
		num1=num;
		System.out.println("By Calling Main");
		while(num>0){
			rev=(rev)+(num%10)*(num%10)*(num%10);
			num=num/10;

		}
		if(rev==num1){
			System.out.println("The Number Is Armstrong"+num);
		}
		else{
			System.out.println("The Number Is Not Armstrong"+num);
		}
		System.out.println("By Calling An Object");
		func f=new func();
		f.armstrong();


		
	}


}