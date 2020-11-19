class employee
{
	String fname,lname;
	//Date doj;
	int salary,bonus;
	public void setfname(String fnm)
	{
		fname = fnm;
	}

	public String getfname()
	{
		return fname;
	}

	public void setlname(String lnm)
	{
		fname = lnm;
	}

	public String getlname()
	{
		return lname;
	}
	
	public void setsalary(int  sal)
	{
		salary = sal;
	}

	public int getsalary()
	{
		return salary;
	}
	
	void calculateBonus(int noyears)
	{
		if(noyears<2)
		{
			bonus+=(salary*10)/100;
		}
		else if(noyears>2)
		{
			bonus+=(salary*20)/100;
		}
	}
}

class manager extends employee
{
	void calculateBonus(int noyears)
	{
		if(noyears<2)
		{
			bonus+=((salary*10)/100)+15000;
		}
		else if(noyears>2)
		{
			bonus+=((salary*20)/100)+15000;
		}
	}
}

public class exam1{
	public static void main(String args[]){
		manager m = new manager();
		m.setfname("Preksha");
		m.setlname("Sheth");
		m.setsalary(20000);
		System.out.println("FName = " + getfname());
		System.out.println("LName = " + getlname());
		System.out.println("Salary = " + getsalary());
	}
}
