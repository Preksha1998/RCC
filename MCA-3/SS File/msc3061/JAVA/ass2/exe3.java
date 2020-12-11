class numSystem{
	int no,a[]=new int[20];
	numSystem(int b){
		no=b;
	}
	void binary(){
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
	void octal(){
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
	void hexadecimal(){
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

class exe3{
	public static void main(String args[]){
		int num=10;
		numSystem n=new numSystem(num);
		n.binary();
		n.octal();
		n.hexadecimal();
	}

}