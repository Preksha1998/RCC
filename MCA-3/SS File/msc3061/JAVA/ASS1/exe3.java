
class exe3{
	public static void main(String args[]){
		int a=1;
		int no1=10;
		int no2=10;
		int ans;
		switch(a){
			case 1:
				ans=no1+no2;
				System.out.println("The Addition Of Two Numbers Is:"+ans);
				break;
			case 2:
				ans=no1-no2;
				System.out.println("The Substraction Of Two Numbers Is:"+ans);
				break;
			case 3:
				ans=no1*no2;
				System.out.println("The Multiplication Of Two Numbers Is:"+ans);
				break;
			case 4:
				ans=no1/no2;
				System.out.println("The Divison Of Two Numbers Is:"+ans);
				break;
			default:
				System.out.println("Invalid");
				
		}
	}


}