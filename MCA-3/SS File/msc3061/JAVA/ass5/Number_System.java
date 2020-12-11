package Number_System;
public class factorial{
	void getFactorial(){
		int num=5,fact=1;
		while(num>0){
			fact=fact*num;
			num--;
		}
	System.out.println("Factorial is::"+fact);
			
	}	
}
public class prime{
	void isPrime(){
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
public class pellingdrome{
	void isPellingdrome(){
		int rev=0,num=121,num1=num;
		while(num>0){
			rev=(rev*10)+(num%10);
			num=num/10;
		}
	if(num==num1){
		System.out.println("Number Is Pellingdrome"+rev);
	}
	else{
		System.out.println("Number Is Not Pellingdrome"+rev);
	}
   }
}