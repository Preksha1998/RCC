class studentdata{
 	int rollno;
	String sname;
	int cyear;
	studentdata(){
		rollno=0;
		sname="new student";
		cyear=0;
	}
	studentdata(int rollno,String sname,int cyear){
		this.rollno=rollno;
		this.sname=sname;
		this.cyear=cyear;
	}
	void setrollno(int rollno){
		this.rollno=rollno;
	}
	void setsname(String sname){
		this.sname=sname;
	}
	void setcyear(int cyear){
		this.cyear=cyear;
	}
	void displaydetails(){
		System.out.println("----------------------------");
		System.out.println("STUDENT'S ROLLNO IS::"+rollno);
		System.out.println("STUDENT'S NAME IS::"+sname);
		System.out.println("STUDENT'S CURRENT YEAR IS::"+cyear);
	}
	void displayrollno(){
		System.out.println("DISPLAYING ROLL NUMBER FROM SETROLLNO FUNCTION");
		System.out.println("ENTERED ROLL NO IS::"+rollno);
	}
	void displayname(){
		System.out.println("DISPLAYING NAME FROM SETNAME FUNCTION");
		System.out.println("ENTERED NAME IS::"+sname);
	}
	void displayyear(){
		System.out.println("DISPLAYING YEAR FROM SETYEAR FUNCTION");
		System.out.println("ENTERED YEAR IS::"+cyear);
	}
}
class exe3{
	public static void main(String args[]){
		studentdata s1=new studentdata();
		s1.displaydetails();
		studentdata s=new studentdata(1001,"Zeel",2018);
		s.displaydetails();
		System.out.println("");
		s.setrollno(1002);
		s.displayrollno();
		System.out.println("");
		s.setsname("KINJAL");
		s.displayname();
		System.out.println("");
		s.setcyear(2018);
		s.displayyear();
	}
}