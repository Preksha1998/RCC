import java.util.*;
interface vehicle{
	//void getdata();
	void display();
}
abstract class veh implements vehicle{
	String model,type,color;
	double speed,milege;
	veh(String m,String t,String c,double s,double m1){
		model=m;
		type=t;
		color=c;
		speed=s;
		milege=m1;
	}
	//void display();

}
class veh1 extends veh{
	veh1(String m,String t,String c,double s,double m1){
		super(m,t,c,s,m1);
	}
        /*public void getdata(){
		Scanner sc=new Scanner(System.in);
		String m=sc.nextLine();
		String t=sc.nextLine();
		String c=sc.nextLine();
		double s=sc.nextDouble();
		double m1=sc.nextDouble();
	}*/	
	public void display(){
		System.out.println(model+type+color+speed+milege);
	}
	

}
class demo{
/*static String m,t,c;
	static double c,m1;*/
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER 1 FOR 2 WHEELER");
		int i=sc.nextInt();
		String m,t,c;
		double s,m1;
		switch(i){
		case 1:
		m=sc.next();
		t=sc.next();
		c=sc.next();
		s=sc.nextDouble();
		m1=sc.nextDouble();
		
		//v.getdata();
		veh1 v=new veh1(m,t,c,s,m1);
		v.display();
		}
	}

}
