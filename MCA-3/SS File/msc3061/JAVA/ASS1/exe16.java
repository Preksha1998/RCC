class func{
	void prime(){
	int i,flag=0,num;
		num=13;
		for(i=2;i<=(num/2);i++){
			if(num%i==0){
				System.out.println("Not Prime");
				flag=1;
				break;
			}
		}
	if(flag==0){
		System.out.println("Number Is Prime");

		}
	}


}
class exe16{
	public static void main(String args[]){
		int i,flag=0,num;
		num=13;
		System.out.println("Calling By Main");
		for(i=2;i<=(num/2);i++){
			if(num%i==0){
				System.out.println("Not Prime");
				flag=1;
				break;
			}
		}
	if(flag==0){
		System.out.println("Number Is Prime");

		}
		System.out.println("Calling By Object");
		func f=new func();
		f.prime();

	}

}