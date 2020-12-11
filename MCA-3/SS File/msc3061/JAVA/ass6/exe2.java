import gujuni.KS.KSMBA;
import gujuni.KS.KSMSC;
import gujuni.ROLLWALA.MCA;
import gujuni.ROLLWALA.PGDCA;
import java.util.*;

class exe2{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER 1 FOR GETTING INFORMATION OF KSMBA");
		System.out.println("ENTER 2 FOR GETTING INFORMATION OF KSMSC");
		System.out.println("ENTER 3 FOR GETTING INFORMATION OF ROLLWALA MCA");
		System.out.println("ENTER 4 FOR GETTING INFORMATION OF ROLLWALA PGDCA");
		System.out.println("ENTER 5 EXIT");
		int i;
		System.out.println("ENTER YOUR CHOICE::");
		i=sc.nextInt();
		switch(i){
		case 1:
			KSMBA k1=new KSMBA();
			k1.firstyear();
			k1.secondyear();
			k1.thirdyear();
			k1.fourthyear();
			k1.fifthyear();
			break;
		case 2:
			KSMSC k2=new KSMSC();
			k2.firstyear();
			k2.secondyear();
			k2.thirdyear();
			k2.fourthyear();
			k2.fifthyear();
			break;
		case 3:
			MCA k3=new MCA();
			k3.firstyear();
			k3.secondyear();
			k3.thirdyear();
			k3.fourthyear();
			k3.fifthyear();
			break;
		case 4:
			PGDCA k4=new PGDCA();
			k4.firstyear();
			k4.secondyear();
			k4.thirdyear();
			k4.fourthyear();
			k4.fifthyear();
			break;
		case 5:
			break;
		}
	}
}