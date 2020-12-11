abstract class bank{
	int acno;
	String actype,acname;
	double opbalance;
	bank(int a,String b,String n,double s){
		acno=a;
		actype=b;
		acname=n;
		opbalance=s;
	}
	abstract void interest();
}
class savingAC extends bank{
	savingAC(int a,String b,String n,double s){
		super(a,b,n,s);

	}
	void interest(){
		double ans;
		ans=opbalance*0.08;
		System.out.println("INTEREST ON SAVING ACCOUNT IS::"+ans);
	}

}
class currentAC extends bank{
	currentAC(int a,String b,String n,double s){
		super(a,b,n,s);

	}
	void interest(){
		double ans;
		ans=opbalance*0.06;
		System.out.println("INTEREST ON CURRENT ACCOUNT IS::"+ans);
	}

}
class exe3{
	public static void main(String args[]){
		savingAC s=new savingAC(101,"SAVING","ABC",20000);
		s.interest();
		currentAC c=new currentAC(102,"CURRENT","XYZ",20000);
		c.interest();
	}
} 
