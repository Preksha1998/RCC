import java.util.*;
class pellingdrome{

	public void isPellingdrome(){
		int rev=0,num,num1;
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER THE NUMBER::");
		num=sc.nextInt();
		num1=num;
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
public class peli{
	public static void main(String args[]){
		pellingdrome p=new pellingdrome();
		p.isPellingdrome();
	}
}