interface facto{
	void factorial();
	void printable();
}
interface fibo extends facto{
	void fibonaki();
	void showable();
}
class facto_fibo implements fibo{
	int fact=1,num=5;
	public void factorial(){
		while(num>0){
			fact*=num;
			num--;		
		}
	}
	public void printable(){
		factorial();
		System.out.println("FACTORIAL IS::"+fact);
	}
	int i=0,j=1,sum=0,n=7;
	public void fibonaki(){
		System.out.println("Fibonaki is::");
		while(n>0){
			System.out.println(sum+"");
			sum=i+j;
			j=i;
			i=sum;
			n--;
		}
	}
	public void showable(){
		fibonaki();
	}
}
class exe1{
	public static void main(String args[]){
		facto_fibo f=new facto_fibo();
		f.printable();
		f.showable();
	}
}	