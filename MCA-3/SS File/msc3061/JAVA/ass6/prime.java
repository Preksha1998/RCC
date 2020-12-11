package Number_System;
public class prime{
	public void isPrime(){
	int i,flag=0,num;
	num=13;
	for(i=2;i<=(num/2);i++){
	if(num%i==0){
		System.out.println("Not Prime::"+num);
		flag=1;
		break;
		}
	}
	if(flag==0){
		System.out.println("Number Is Prime::"+num);
	}
	
			
	}	
}
