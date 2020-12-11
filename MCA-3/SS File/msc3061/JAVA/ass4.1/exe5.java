interface abc{
	void factorial();
}
abstract class def implements abc{
	public void factorial(){
		System.out.println("IMPLEMENTING INTERFACE METHOD::");
		int fact=1,num=5;
		while(num>0){
			fact=fact*num;
			num--;
		}
		System.out.println("FACTORIAL IS::"+fact);
	}
	abstract void pow();
}
class mno extends def{
	void pow(){
		System.out.println("IMPLEMENTING ABSTRACT METHOD::");
		int m=2,n=4,p=1;
		while(n>0){
			p*=m;
			n--;
		}
	System.out.println("POWER IS::"+p);
	}
}
class exe5{
	public static void main(String args[]){
		mno m=new mno();
		m.factorial();
		m.pow();
	}
}