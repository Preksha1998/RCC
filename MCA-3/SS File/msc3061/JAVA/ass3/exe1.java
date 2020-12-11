class employee{
	String eid,ename,des,dob;
	employee(String eid,String ename,String des,String dob){
		this.eid=eid;
		this.ename=ename;
		this.des=des;
		this.dob=dob;
	}
	void empdetails(){
		System.out.println("EMPLOYEE ID IS::"+eid);
		System.out.println("EMPLOYEE NAME IS::"+ename);
		System.out.println("EMPLOYEE'S DESIGNATION IS::"+des);
		System.out.println("DATE OF BIRTH IS::"+dob);
	}
	
}
class exe1{
	public static void main(String args[]){
		employee e=new employee("E01","HETVEE SHAH","MANAGER","01-01-1999");
		e.empdetails();
	}

}