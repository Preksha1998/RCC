abstract class employee {
    int emp_id ;
    String fname;
    String lname ;
    float salary;
    String designation;
    float bonus;

    employee(int emp_id,String fname,String lname,float salary,String designation){
     this.emp_id = emp_id ;
     this.fname =fname;
     this.lname = lname;
     this.salary =salary;
     this.designation = designation ;
    }

    abstract void calculate_bonus();
	abstract void display();
}

class clerk extends employee{

    int no_of_hrs_worked ; 

    clerk(int emp_id,String fname,String lname,float salary,String designation, int c_n_w){
        super(emp_id,fname,lname,salary,designation);
        this.no_of_hrs_worked = c_n_w ;
    }
    void calculate_bonus(){
        if(no_of_hrs_worked > 250 ){
            this.bonus = ( no_of_hrs_worked - 250 ) * 200 ;
        }
        else{
            this.bonus = 0 ;
        }
    }
    void display(){
        calculate_bonus();
        System.out.println("Employee id is : " + this.emp_id);
        System.out.println("Employee first name is : " + this.fname);
        System.out.println("Employee last name is : " + this.lname);
        System.out.println("Employee designation is : " + this.designation);
        System.out.println("Employee basic salary is : " + this.salary);
        System.out.println("Employee bonus is : " + this.bonus);
        System.out.println("Employee total salary is : " + (this.salary + this.bonus));
    }
}

class meneger extends employee{
    int no_project;
    meneger(int emp_id,String fname,String lname,float salary,String designation, int n_o_p){
        super(emp_id,fname,lname,salary,designation);
        this.no_project = n_o_p ;
    }

    void calculate_bonus(){
        this.bonus = (no_project * 1000) ;
    }
	
    void display(){
        calculate_bonus();
        System.out.println("Employee id is : " + this.emp_id);
        System.out.println("Employee first name is : " + this.fname);
        System.out.println("Employee last name is : " + this.lname);
        System.out.println("Employee designation is : " + this.designation);
        System.out.println("Employee basic salary is : " + this.salary);
        System.out.println("Employee bonus is : " + this.bonus);
        System.out.println("Employee total salary is : " + (this.salary+this.bonus));
    }
}

public class a2_p14{
    public static void main(String[] args){
		
		employee[] emp=new employee[5];
		
		emp[0] = new clerk(1,"Kriya","pandya",750000,"Clerk",260);
		emp[1] = new clerk(2,"ravi","shah",650000,"Clerk",400);
		emp[2] = new clerk(3,"pushti","sampat",850000,"Clerk",200);
		emp[3] = new meneger(1,"Preksha","Sheth",950000,"Manager",3);
		emp[4] = new meneger(2,"abhi","Patel",350000,"Manager",5);
		
		for(int i=0; i<5; i++)
		{
			System.out.println("\n*************************************\n");
			emp[i].display();
		}
    }
}