import java.util.*;
interface conversion{
	void stringToBinary(int n);
	void stringToOctal(int n);
	void stringToHexa(int n);
}
class numSystem implements conversion{
	int no,a[]=new int[20];

	public void stringToBinary(int no){
		int n=no;
		System.out.println("Decimal To Binary::");
		int i=0;
		while(n>0){
			a[i]=n%2;
			i++;
			n=n/2;
		}
		for(int j=i-1;j>=0;j--){
			System.out.println(""+a[j]);
		}
	}
	public void stringToOctal(int no){
		int n=no;
		System.out.println("Decimal To Octal::");
		int i=0;
		while(n>0){
			a[i]=n%8;
			i++;
			n=n/8;
		}
		for(int j=i-1;j>=0;j--){
			System.out.println(""+a[j]);
		}
	}
	public void stringToHexa(int no){
		int n=no,rem=1;
		System.out.println("Decimal To HexaDecimal::");
		int i=0;
		while(n>0){
			rem=n%16;
			n=n/16;
			a[i]=rem;
			i++;
			
		}
		for(int j=i-1;j>=0;j--){
			
			if(a[j]==10){
				System.out.println("a");
			}
			else if(a[j]==11){
				System.out.println("b");
			}
			else if(a[j]==12){
				System.out.println("c");
			}
			else if(a[j]==13){
				System.out.println("d");
			}
			else if(a[j]==14){
				System.out.println("e");
			}
			else if(a[j]==15){
				System.out.println("f");
			}
			else{
				System.out.println(""+a[j]);
			}
		}
	}


}

class exe7{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);		
		numSystem n=new numSystem();
		System.out.println("ENTER 1 FOR CONVERSION FROM DECIMAL TO BINARY");
		System.out.println("ENTER 2 FOR CONVERSION FROM DECIMAL TO OCTAL");
		System.out.println("ENTER 3 FOR CONVERSION FROM DECIMAL TO HEXADECIMAL");
		System.out.println("ENTER 4 FOR EXIT");
		System.out.println("ENTER THE CHOICE::");
		int i=sc.nextInt();
		
		switch(i){

			case 1:
				int num;
				System.out.println("ENTER THE NUMBER::");
				num=sc.nextInt();
				n.stringToBinary(num);
				break;

			case 2:
				int num1;
				System.out.println("ENTER THE NUMBER::");
				num1=sc.nextInt();
				n.stringToOctal(num1);
				break;
			case 3:
	
				int num2;
				System.out.println("ENTER THE NUMBER::");
				num2=sc.nextInt();			
				n.stringToHexa(num2);	
				break;
			case 4:
				return;
		}

	}

}