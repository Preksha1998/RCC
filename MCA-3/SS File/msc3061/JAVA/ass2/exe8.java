class Employee{
	double gs,bs,da,hra;
	String ename,des;
	Employee(String name,String designation,double salary){
		ename=name;
		des=designation;
		bs=salary;
	}
	void print(){
		da=bs*0.05;
		hra=bs*0.10;
		gs=bs+hra+da;
		System.out.println("Employee Name Is::"+ename);
		System.out.println("Employee's Designation Is::"+des);
		System.out.println("Employee's Salary Is::"+bs);
		System.out.println("Employee's DA Is::"+da);
		System.out.println("Employee's HRA Is::"+hra);
		System.out.println("Employee's Gross Salary Is::"+gs);
	}
}
class exe8{
	public static void main(String args[]){
	Employee e=new Employee("Hetvee Shah","Manager",50000);
	e.print();
	}
	

}