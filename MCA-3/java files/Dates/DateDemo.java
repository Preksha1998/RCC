import java.util.*;
class DateDemo{
	
	public static void main (String[] args) {
		Date currdate = new Date();
		System.out.println(currdate);
		Date epoch = new Date(0);
		System.out.println(epoch);
		long millis=System.currentTimeMillis();
		
		System.out.println(millis);
	}



}