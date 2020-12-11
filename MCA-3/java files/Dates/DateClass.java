import java.util.Date;

public class DateClass{
	
	public static void main (String[] args) {
		Date date = new Date();
		System.out.println(date.toString());
		System.out.println(date.getTime());
		System.out.println(date.getMonth());
	}
}