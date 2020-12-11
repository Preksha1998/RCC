class Member{
	int power(int m,int n){
		int p=1;
		while(n>0){
			p=p*m;
			n--;
		}
		return p;
	}
	int cube(int num){
		return (num*num*num);
	}
	int reverse(int num){
		int rev=0;
		while(num>0){
			rev=(rev*10)+(num%10);
			num=num/10;

	
		}
	return rev;

	}	
}
class exe2{
	public static void main(String args[]){
		Member m=new Member();
		int pow,c,rev;
		pow=m.power(2,3);
		System.out.println("The Power is::"+pow);
		c=m.cube(3);
		System.out.println("The Cube Is::"+c);
		rev=m.reverse(123);
		System.out.println("The Reverse Number Is::"+rev);
	}

}