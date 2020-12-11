interface demo{
	int add(int num1,int num2);
}
interface demo1 extends demo{
	int sub(int num1,int num2);
}
class demo2 implements demo1{
	public int add(int num1,int num2){
		return num1+num2;
	}
	public int sub(int num1,int num2){
		return num1-num2;
	}
}
class exe18{
	public static void main(String args[]){
		demo2 a=new demo2();
		demo2 s=new demo2();
		System.out.println("ADDITION THROUGH INTERFACE::"+a.add(10,20));
		System.out.println("SUBTRACTION THROUGH INTERFACE::"+s.sub(10,20));
	}
}