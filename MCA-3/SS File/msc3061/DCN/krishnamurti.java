import java.util.*;
class func{
	

	int fact(int no){
			while(no>0){
			fact=fact*no;
			no--;
			}
			return no;
		}
	void factorial(){
		int fact=1,num,sum=0,num1,rev=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE NUMBER::");
		num=sc.nextInt();
		num1=num;
		
		while(num>0){
			sum=num%10;
			rev=rev+(fact(sum));
			num=num/10;

		}
		if(fact==num1){
			System.out.println("The Number Is KRISHNAMURTI::"+fact);
		}
		else{
			System.out.println("The Number Is Not KRISHNAMURTI::"+fact);
		}
		


	}

}
class krishnamurti{
	public static void main(String args[]){
		func f=new func();
		f.factorial();

	}

}