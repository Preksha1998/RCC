abstract class demo{
	abstract void sum(int a,int b);
}
class demo1 extends demo{
	void sum(int a,int b){
		int ans=a+b;
		System.out.println("THE ANS IS::"+ans);
	}

}
class exe16{
	public static void main(String args[]){
		demo1 d=new demo1();
		d.sum(10,20);
	}	

}