import Number_System.factorial;
import Number_System.prime;
import Number_System.pellingdrome;
import Number_System.stringoperation;
class p_exe1{	
	public static void main(String args[]){
		factorial f=new factorial();
		f.getFactorial();
		prime p=new prime();
		p.isPrime();
		pellingdrome p1=new pellingdrome();
		p1.isPellingdrome();
		stringoperation s=new stringoperation();
		s.sort();
		s.rev();
	}
}