class employee
{
	String fname,lname;
	Date doj;
	int salary,bonus;
	
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
			bonus+=((salary*10)/100)+15000);
		}
		else if(noyears>2)
		{
			bonus+=((salary*20)/100)+15000;
		}
	}
}

public class exam{
	public static void main(String args[]	{

}
}