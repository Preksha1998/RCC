class swap{
	int a,b;
	swap(int n1,int n2){
		a=n1;
		b=n2;
	}
	void swapval(){
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("The Values After Swapping Is::"+"NUM1::"+a+" "+"NUM2::"+b);
	}


}
class exe13{
	public static void main(String args[]){
		int num1=10;
		int num2=20;
		swap s=new swap(num1,num2);	
		System.out.println("The Values Before Swapping Is::"+"NUM1::"+num1+" "+"NUM2::"+num2);
		s.swapval();

	
	}

}

