import java.util.*;
class func{
	int pow(int m,int n){
		int ans=1;
		while(n>0){
			ans=ans*m;
			n--;
		}
		return ans;
	}


	void armstrong(){
		int rev=0,num,sum=0,num1,cnt=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE NUMBER::");
		num=sc.nextInt();
		num1=num;
		while(num>0){
			cnt++;
			num=num/10;
		}
		num=num1;
		while(num>0){
			sum=num%10;
			rev=(rev)+pow(sum,cnt);
			num=num/10;

		}
		if(rev==num1){
			System.out.println("The Number Is Armstrong::"+rev);
		}
		else{
			System.out.println("The Number Is Not Armstrong::"+rev);
		}
		


	}

}
class arm{
	public static void main(String args[]){
		func f=new func();
		f.armstrong();

	}

}