package Number_System;
public class pellingdrome{
	public void isPellingdrome(){
		int rev=0,num=121,num1=num;
		while(num>0){
			rev=(rev*10)+(num%10);
			num=num/10;
		}
	if(num1==rev){
		System.out.println("Number Is Pellingdrome::"+rev);
	}
	else{
		System.out.println("Number Is Not Pellingdrome::"+rev);
	}
   }
}